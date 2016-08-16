package ch.keepcalm.web.controller;

import ch.keepcalm.web.controller.assembler.CustomerResourceAssembler;
import ch.keepcalm.web.model.Customer;
import ch.keepcalm.web.resource.CustomerResource;
import ch.keepcalm.web.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/customers", produces = "application/hal+json")
public class CustomerController {

    @Autowired
    private CustomerService service;
    @Autowired
    private CustomerResourceAssembler resourceAssembler;
    @Autowired
    public void setCustomerController(CustomerService customerService, CustomerResourceAssembler customerResourceAssembler) {
        this.service = customerService;
        this.resourceAssembler = customerResourceAssembler;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CustomerResource postCustomer(@RequestBody CustomerResource customerResource) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerResource, customer);
        return resourceAssembler.toResource(service.createCustomer(customer));

    }


    @GetMapping
    public CustomerResource getCustomer(@RequestParam int id) {
        return resourceAssembler.toResource(service.getCustomer(id));
    }

}
