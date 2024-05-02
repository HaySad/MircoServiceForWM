package exmicroservices.book.microservices1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> getAllCustomers() {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }
}
