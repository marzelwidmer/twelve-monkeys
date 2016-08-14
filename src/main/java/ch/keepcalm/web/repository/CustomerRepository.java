package ch.keepcalm.web.repository;

import ch.keepcalm.web.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author marcelwidmer
 */
public interface CustomerRepository extends CrudRepository<Customer,  Integer> {

}
