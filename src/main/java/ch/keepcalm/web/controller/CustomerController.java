package ch.keepcalm.web.controller;

import ch.keepcalm.web.controller.assembler.CustomerResourceAssembler;
import ch.keepcalm.web.model.Customer;
import ch.keepcalm.web.model.Product;
import ch.keepcalm.web.resource.CustomerResource;
import ch.keepcalm.web.resource.ProductPackageResource;
import ch.keepcalm.web.resource.ProductResource;
import ch.keepcalm.web.service.CustomerService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/customers", produces = "application/hal+json")
public class CustomerController {

    private CustomerService service;
    private CustomerResourceAssembler resourceAssembler;

    @Autowired
    public void setCustomerController(CustomerService customerService, CustomerResourceAssembler customerResourceAssembler) {
        this.service = customerService;
        this.resourceAssembler = customerResourceAssembler;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CustomerResource postCustomer(@RequestBody CustomerResource customerResource) {

        Mapper mapper = new DozerBeanMapper();
        Customer destObject = mapper.map(customerResource, Customer.class);
        Customer result = service.createCustomer(destObject);

        return resourceAssembler.toResource(result);

    }


    // TODO: 16/08/16 implement me... or refactor it in own controller class ?
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{id}/product_package")
    public ProductResource postProductPackage(@RequestBody ProductPackageResource productResource) {

        Mapper mapper = new DozerBeanMapper();
        for (ProductResource resource : productResource.getProducts()) {
            Product destObject = mapper.map(resource, Product.class);
            Product result = service.createProduct(destObject);

        }


        return null; //resourceAssembler.toResource(result);

    }


    @GetMapping(value = "{id}")
    public CustomerResource getCustomer(@PathVariable int id) {
        return resourceAssembler.toResource(service.getCustomer(id));
    }

}
