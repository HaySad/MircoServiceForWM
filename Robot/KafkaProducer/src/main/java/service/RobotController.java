package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController {

    //private final CustomerService customerService;
    
    @Autowired
    private RobotRepository repositor;
    private String key;

    @KafkaListener(topics = "Robot", groupId = "my-group-id")
    public void listen(Robot rob) {
    	key = rob.getInventorySpaceKey();
    	rob.setAlreadyMoved("Y");
        System.out.println("ID: "+rob.getRobotId()+ rob.getInventorySpaceKey() + rob.getQrcode() + "Is Done And AlreadyMoved: " + rob.getAlreadyMoved());
       
    }
    
    @GetMapping("/cheackEmptySpace")
    public Robot getId() {
    	Optional<Robot> rob = repositor.findById(key);
    	if(rob.get().getInventorySpaceKey() == key) {
        	System.out.println(rob.get());
        }
    }
    	
		return rob.get();
    }
    
}