package com.bruce.listen;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "output-topic", groupId = "test-group")
    public void listen(String message) {
        System.out.println("Received Message: " + message);
    }
}
