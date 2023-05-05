package com.achsat.crypto.payment.service;

import com.achsat.crypto.payment.model.CashAccount;
import com.achsat.crypto.payment.model.TransactionHistory;
import com.achsat.crypto.entity.dto.Order;
import com.achsat.crypto.payment.repository.AccountRepository;
import com.achsat.crypto.payment.repository.TransactionHistoryRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderManageService {

    private static final String SOURCE = "payment";
    private static final Logger LOG = LoggerFactory.getLogger(OrderManageService.class);
    @Autowired
    private AccountRepository acctRepo;
    @Autowired
    private TransactionHistoryRepository txnRepo;

    @Autowired
    private KafkaTemplate<Long, Order> template;

    @Transactional
    public void reserve(Order order) {
        Optional<CashAccount> account = acctRepo.findByCustomerId(order.getCustomerId());

        if(account.isPresent()) {
            LOG.info("Found: {}", account);
            if (BigDecimal.valueOf(order.getPrice()).compareTo(account.get().getCashBalance()) < 0) {
                order.setStatus("ACCEPT");
                account.get().setReservedBalance(account.get().getReservedBalance().add(BigDecimal.valueOf(order.getPrice())));
                account.get().setCashBalance(account.get().getCashBalance().subtract(BigDecimal.valueOf(order.getPrice())));

            } else {
                order.setStatus("REJECT");
            }
            order.setSource(SOURCE);
            TransactionHistory txn = new TransactionHistory(account.get().getAccountId()
                    ,"Debit"
                    ,BigDecimal.valueOf(order.getPrice())
                    , LocalDateTime.now());
            acctRepo.save(account.get());
            txnRepo.save(txn);

        } else {
            order.setStatus("REJECT");
        }
        template.send("payment-orders", order.getId(), order);
        LOG.info("Sent: {}", order);
    }

    @Transactional
    public void confirm(Order order) {
        CashAccount account = acctRepo.findByCustomerId(order.getCustomerId()).get();

        LOG.info("Found: {}", account);
        if (order.getStatus().equals("CONFIRMED")){
            account.setReservedBalance(account.getReservedBalance().subtract(BigDecimal.valueOf(order.getPrice())));
            acctRepo.save(account);
        } else if (order.getStatus().equals("ROLLBACK") && !order.getSource().equals(SOURCE)) {
            account.setReservedBalance(account.getReservedBalance().subtract(BigDecimal.valueOf(order.getPrice())));
            account.setCashBalance(account.getCashBalance().add(BigDecimal.valueOf(order.getPrice())));
            acctRepo.save(account);

            TransactionHistory txn = new TransactionHistory(account.getAccountId()
                    ,"Credit"
                    ,BigDecimal.valueOf(order.getPrice())
                    , LocalDateTime.now());
            acctRepo.save(account);
            txnRepo.save(txn);

        }

    }
}
