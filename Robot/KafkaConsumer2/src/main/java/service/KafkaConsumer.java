package service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	 @KafkaListener(topics = "Robot", groupId = "my-group-id")
	    public void listen(String message) {
	        System.out.println("Received message: " + message);
	    }
}
