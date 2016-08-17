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

        // api/customers/1; rel="self
        CustomerResource customerResource = createResourceWithId(customer.getId(), customer);

        Mapper mapper = new DozerBeanMapper();
        customerResource = mapper.map(customer, CustomerResource.class);

        Link self = new Link(linkTo(CustomerController.class)
                .slash(customer.getId())
                .toUriComponentsBuilder().build().toUriString(), "self");
        customerResource.add(self);


        // GET products http://localhost:8080/api/customers/1/products; rel="list_products"
        Link listProducts = new Link(linkTo(CustomerController.class)
                .slash(customer.getId())
                .slash("product-package").toUriComponentsBuilder().build().toUriString(), "list_package");
        customerResource.add(listProducts);

        // POST products http://localhost:8080/api/customers/1/products; rel="create_product"
        Link createProducts = new Link(linkTo(CustomerController.class)
                .slash(customer.getId())
                .slash("product-package").toUriComponentsBuilder().build().toUriString(), "create_package");
        customerResource.add(createProducts);


        // POST products http://localhost:8080/api/customers/1/deeplink; rel="create_deeplink"
        Link deeplink = new Link(linkTo(CustomerController.class)
                .slash(customer.getId())
                .slash("deeplink").toUriComponentsBuilder().build().toUriString(), "create_deeplink");
        customerResource.add(deeplink);

        return customerResource;
    }

}
