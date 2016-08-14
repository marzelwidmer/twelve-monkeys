package ch.keepcalm.web.repository;

import ch.keepcalm.web.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author marcelwidmer
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer,  Integer> {

}
