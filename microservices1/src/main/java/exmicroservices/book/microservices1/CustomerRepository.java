package exmicroservices.book.microservices1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import exmicroservices.book.microservices1.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}