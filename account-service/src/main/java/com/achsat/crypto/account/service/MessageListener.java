package com.achsat.crypto.account.service;

import com.achsat.crypto.dto.TransactionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    private static final Logger LOG = LoggerFactory
            .getLogger(MessageListener.class);

    @KafkaListener(id="account-coba", topics="coba-coba")
    public void listen(TransactionDTO dto){
        LOG.info("message consumed, account id: " + dto.getAccountID() +" amount: " + dto.getAmount().toString());
    }
}
