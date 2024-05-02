package exmicroservices.book.microservices1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import exmicroservices.book.microservices1.Customer;
import exmicroservices.book.microservices1.CustomerRepository;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // สามารถเพิ่มเมทอดอื่น ๆ ตามที่ต้องการ
}