package service;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig; 
import org.apache.kafka.common.serialization.StringDeserializer; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.kafka.annotation.EnableKafka; 
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory; 
import org.springframework.kafka.core.ConsumerFactory; 
import org.springframework.kafka.core.DefaultKafkaConsumerFactory; 
import org.springframework.kafka.support.serializer.JsonDeserializer; 
import exmicroservices.book.microservices1.Customer;

@EnableKafka
@Configuration
public class KafkaConfig {
	@Bean
    public ConsumerFactory<String, Customer> consumerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group-id");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(
        		configProps, new StringDeserializer(),new JsonDeserializer<>(Customer.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Customer> ShipperListenner() {
        ConcurrentKafkaListenerContainerFactory<String, Customer> factory = new ConcurrentKafkaListenerContainerFactory<String, Customer>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
    
}