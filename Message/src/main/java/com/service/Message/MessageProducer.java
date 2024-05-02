package com.service.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void sendMessage(String topic, String message) {
        if (isDatabaseReachable()) {
            kafkaTemplate.send(topic, message);
        } else {
            System.out.println("Unable to connect to the database.");
        }
    }

    public boolean isDatabaseReachable() {
        try {
            jdbcTemplate.execute("SELECT 1"); // ทดสอบการเชื่อมต่อกับฐานข้อมูล
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
