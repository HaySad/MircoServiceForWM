package exmicroservices.book.microservices1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    //private final CustomerService customerService;
    
    @Autowired
    private CustomerRepository repositor;
    
    @Autowired
    private MessageProducer messageProducer;

    /*@GetMapping("/")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    */
    @GetMapping("/cheackCar")
    public Customer getId(@RequestParam("License")Integer num) {
    	Optional<Customer> cut = repositor.findById(num);
    	//cut.get().setAlreadyShipped("Y");
    	repositor.save(cut.get());
    	System.out.print(cut.get());
    	
    	messageProducer.sendMessage("SPNEW", cut.get());
    	
		return cut.get();
    }
    
}