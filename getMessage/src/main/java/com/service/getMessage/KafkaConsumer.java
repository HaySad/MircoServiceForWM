package com.service.getMessage;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import exmicroservices.book.microservices1.Customer;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "SPNEW", groupId = "my-group-id", containerFactory = "ShipperListenner")
    public void listen(Customer cut) {
        System.out.println("ID: "+cut.getId()+ cut.getLicensePlate() + cut.getFirstName() + "Is Done");
    }
}
