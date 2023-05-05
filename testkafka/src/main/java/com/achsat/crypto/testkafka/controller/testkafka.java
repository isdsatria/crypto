package com.achsat.crypto.testkafka.controller;

import com.achsat.crypto.entity.dto.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Controller
public class testkafka {

    @Autowired
    KafkaTemplate<Long, TransactionDTO> kafkaTemplate;

    @PostMapping("/publish")
    public ResponseEntity<?> publish(@RequestBody TransactionDTO dto){
        try {
            Long id = new Date().getTime();
            kafkaTemplate.send("coba-coba", dto);
            return ResponseEntity.ok().body("published");
        }catch(Exception e){
            return ResponseEntity.ok().body("gagal bro");
        }
    }

}
