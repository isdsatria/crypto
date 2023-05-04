package com.achsat.crypto.customer;

import com.achsat.crypto.customer.model.CustomerAssets;
import com.achsat.crypto.customer.service.ICustomerAssetService;
import com.achsat.crypto.customer.service.ICustomerService;
import com.achsat.crypto.entity.dto.AssetDTO;
import com.achsat.crypto.entity.dto.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import java.math.BigDecimal;

@SpringBootApplication
@EnableKafka
public class CustomerApplication {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerApplication.class);

	@Autowired
	ICustomerAssetService service;
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@KafkaListener(id = "customer", topics = "orders", groupId = "customer")
	public void onEvent(Order o){
		LOG.info("Received: {}" , o);
		if(o.getStatus().equals("CONFIRMED")){
			AssetDTO asset = new AssetDTO();
			asset.setCustomerId(o.getCustomerId());
			asset.setCoinId(o.getCoinId());
			asset.setQty(BigDecimal.valueOf(o.getCoinCount()));
			service.addAsset(asset);
		}
	}


}
