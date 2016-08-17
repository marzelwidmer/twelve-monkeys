package ch.keepcalm.web.service;

import ch.keepcalm.web.model.Customer;
import ch.keepcalm.web.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {


    private CustomerRepository repository;

    @Autowired
    public void setCustomerService(CustomerRepository repository) {
        this.repository = repository;
    }


    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }


    public Customer getCustomer(int id) {
        return repository.findOne(id);
    }



    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        for (Customer model : repository.findAll()) {
            customers.add(model);
        }
        return customers;
    }


}
