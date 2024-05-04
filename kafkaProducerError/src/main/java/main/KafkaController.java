package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
	private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private MessageProducer messageProducer;

    @GetMapping("/")
    public String message() {
        return "---------Hello Spring Boot App------------";
    }

    @GetMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestParam("message") String message) {
        
        logger.info("Received message: {}", message);

        boolean productFound = checkProductInDatabase(message);

        if (productFound) {
            
            logger.info("No error: Product found - {}", message);
            
            messageProducer.sendMessage("POS2WMS", message);
         
            logger.info("Scan sent successfully: {}", message);
            return ResponseEntity.ok("Scan : " + message);
        } else {
            
            logger.error("Error: Product not found - {}", message);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No product : " + message);
        }
    }

    private boolean checkProductInDatabase(String productId) {
        return true; 
    }

    
	}

  