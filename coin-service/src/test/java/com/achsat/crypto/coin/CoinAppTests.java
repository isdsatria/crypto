package com.achsat.crypto.coin;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest(properties = {"spring.kafka.consumer.auto-offset-reset=earliest"})
@EmbeddedKafka(topics = {"stock-orders"},
        partitions = 1,
        bootstrapServersProperty = "spring.kafka.bootstrap-servers")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CoinAppTests {

}
