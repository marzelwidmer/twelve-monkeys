package ch.keepcalm.web.controller.assembler;

import ch.keepcalm.web.controller.CustomerController;
import ch.keepcalm.web.model.Customer;
import ch.keepcalm.web.resource.CustomerResource;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.web.bind.annotation.ControllerAdvice;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@ControllerAdvice
public class CustomerResourceAssembler extends ResourceAssemblerSupport<Customer, CustomerResource> {

    public CustomerResourceAssembler() {
        super(CustomerController.class, CustomerResource.class);
    }

    @Override
    public CustomerResource toResource(Customer customer) {
        CustomerResource result = instantiateResource(customer);
        BeanUtils.copyProperties(customer, result);
        result.add(linkTo(CustomerController.class).withRel("self"));
        return result;
    }
}
