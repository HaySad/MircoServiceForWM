package main;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class kafkaConsumer {
	@KafkaListener(topics = "POS2WMS", groupId = "my-group-id")
	public void consume(@Payload String message) {
	    if (message != null && !message.isEmpty()) {
	        System.out.println("No error: Product found - " + message);
	        
	    } else {
	        System.out.println("Error: Product not found - " + message);
	    }
	}

}

