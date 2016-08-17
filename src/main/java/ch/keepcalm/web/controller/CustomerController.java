package ch.keepcalm.web.controller;

import ch.keepcalm.web.controller.assembler.CustomerResourceAssembler;
import ch.keepcalm.web.model.Customer;
import ch.keepcalm.web.model.ProductPackage;
import ch.keepcalm.web.resource.CustomerProductPackageResource;
import ch.keepcalm.web.resource.CustomerResource;
import ch.keepcalm.web.resource.ProductResource;
import ch.keepcalm.web.service.CustomerService;
import ch.keepcalm.web.service.ProductPackageService;
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

    private CustomerService customerService;;
    private ProductPackageService productPackageService;
    private CustomerResourceAssembler resourceAssembler;

    @Autowired
    public void setCustomerController(CustomerService customerService, CustomerResourceAssembler customerResourceAssembler, ProductPackageService productPackageService) {
        this.customerService = customerService;
        this.resourceAssembler = customerResourceAssembler;
        this.productPackageService = productPackageService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CustomerResource postCustomer(@RequestBody CustomerResource customerResource) {

        Mapper mapper = new DozerBeanMapper();
        Customer destObject = mapper.map(customerResource, Customer.class);
        Customer result = customerService.createCustomer(destObject);

        return resourceAssembler.toResource(result);

    }


    // TODO: 16/08/16 implement me... or refactor it in own controller class ?
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{id}/productpackage")
    public ProductResource postProductPackage(@RequestBody CustomerProductPackageResource productPackageResource) {


        Mapper mapper = new DozerBeanMapper();
        ProductPackage destObject = mapper.map(productPackageResource, ProductPackage.class);
        ProductPackage result = productPackageService.createProductPackage(destObject);

        System.out.println(result.getProducts().size());
        return null; //resourceAssembler.toResource(result);

    }


    @GetMapping(value = "{id}")
    public CustomerResource getCustomer(@PathVariable int id) {
        return resourceAssembler.toResource(customerService.getCustomer(id));
    }

}
