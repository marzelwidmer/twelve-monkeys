package ch.keepcalm.web.controller.assembler;

import ch.keepcalm.web.controller.CustomerController;
import ch.keepcalm.web.model.Customer;
import ch.keepcalm.web.resource.CustomerResource;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.hateoas.Link;
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

        Mapper mapper = new DozerBeanMapper();
        CustomerResource customerResource = mapper.map(customer, CustomerResource.class);

        Link self = new Link(linkTo(CustomerController.class)
                .slash(customer.getId())
                .toUriComponentsBuilder().build().toUriString(), "self");
        customerResource.add(self);


        // POST products http://localhost:8080/api/customers/1/products; rel="create_product"
        Link createProducts = new Link(linkTo(CustomerController.class)
                .slash(customer.getId())
                .slash("productpackage").toUriComponentsBuilder().build().toUriString(), "createProductpackage");
        customerResource.add(createProducts);


        return customerResource;
    }

}
