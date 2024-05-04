package exmicroservices.book.microservices1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.messaging.Message;



@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, Customer> kafkaTemplate;

    public void sendMessage(String topic, Customer cut) {
         Message<Customer> message = MessageBuilder
        		 .withPayload(cut)
        		 .setHeader(KafkaHeaders.TOPIC, topic)
        		 .build();
         kafkaTemplate.send(message);
    }


}
