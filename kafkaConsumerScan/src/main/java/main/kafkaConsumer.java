package main;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkaConsumer {
@KafkaListener(topics = "POS2WMS", groupId = "my-group-id")
	
    public void consume(String message) {
        System.out.println("Scan : " + message);
    }
}
