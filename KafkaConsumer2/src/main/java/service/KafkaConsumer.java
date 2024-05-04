package service;

import java.util.Optional;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import exmicroservices.book.microservices1.Customer;

@Service
public class KafkaConsumer {

	private String license;
	private ItemsRepository repositor;
	
    @KafkaListener(topics = "SPNEW", groupId = "my-group-id", containerFactory = "ShipperListenner")
    public void listen(Customer cut) {
    	license = cut.getLicensePlate();
    	cut.setAlreadyShipped("Y");
        System.out.println("ID: "+cut.getId()+ cut.getLicensePlate() + cut.getFirstName() + "Is Done And AlreadyShipped: " + cut.getAlreadyShipped());
       
    }
    @GetMapping("/cheackInputItem")
    public void checkItem() {
    	Optional<Items> item = repositor.findByLicense(license);
    	if(item.get().getLicensePlate() == license) {
        	System.out.println(item.get());
        }
    	//แสดงไอเท็มที่มี ค่าของทพเบียนรถเท่ากันกับที่รับ message มา
    }
    
}