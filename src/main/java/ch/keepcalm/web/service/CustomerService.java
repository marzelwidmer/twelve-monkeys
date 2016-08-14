package ch.keepcalm.web.service;

import ch.keepcalm.web.model.Customer;
import ch.keepcalm.web.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

   @Autowired
    private CustomerRepository repository;
    @Autowired
    public void setCustomerService(CustomerRepository repository) {
        this.repository = repository;
    }


    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }




}
