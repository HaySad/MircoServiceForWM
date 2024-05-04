package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
	@Autowired
    private MessageProducer messageProducer;

	@GetMapping("/")
	public String message() {
		return"---------Scanning------------";
	}
	
    @GetMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestParam("message") String message) {
        messageProducer.sendMessage("POS2WMS", message);
        return ResponseEntity.ok("Scan : " + message);
    }
}
