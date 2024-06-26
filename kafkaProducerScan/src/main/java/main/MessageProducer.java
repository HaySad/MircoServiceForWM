package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service 
public class MessageProducer {
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String topicName, String message) {
	kafkaTemplate.send(topicName, message) ;
  }
}
