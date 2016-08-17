package ch.keepcalm.web.controller;

import ch.keepcalm.web.controller.assembler.CustomerResourceAssembler;
import ch.keepcalm.web.controller.assembler.ProductPackageResourceAssembler;
import ch.keepcalm.web.model.Customer;
import ch.keepcalm.web.model.ProductPackage;
import ch.keepcalm.web.resource.CustomerResource;
import ch.keepcalm.web.resource.ProductPackageResource;
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
    private CustomerResourceAssembler customerResourceAssembler;
    private ProductPackageResourceAssembler productPackageResourceAssembler;


    @Autowired
    public void setCustomerController(CustomerService customerService, CustomerResourceAssembler customerResourceAssembler,
                                      ProductPackageService productPackageService,
                                      ProductPackageResourceAssembler productPackageResourceAssembler) {
        this.customerService = customerService;
        this.customerResourceAssembler = customerResourceAssembler;

        this.productPackageService = productPackageService;
        this.productPackageResourceAssembler = productPackageResourceAssembler;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CustomerResource postCustomer(@RequestBody CustomerResource customerResource) {

        Mapper mapper = new DozerBeanMapper();
        Customer destObject = mapper.map(customerResource, Customer.class);
        Customer result = customerService.createCustomer(destObject);

        return customerResourceAssembler.toResource(result);

    }


    // TODO: 16/08/16 implement me... or refactor it in own controller class ?
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{id}/product-package")
    public ProductPackageResource postProductPackage(@RequestBody ProductPackageResource productPackageResource, @PathVariable int id) {


        Mapper mapper = new DozerBeanMapper();
        ProductPackage destObject = mapper.map(productPackageResource, ProductPackage.class);
        ProductPackage productPackageroductPackage = productPackageService.createProductPackage(destObject);

        Customer customer = customerService.getCustomer(id); // TODO: 17/08/16 update customer with product packages
        customer.getProductPackage().add(productPackageroductPackage);
        customerService.updateCustomer(customer);


        return productPackageResourceAssembler.toResource(productPackageroductPackage); //customerResourceAssembler.toResource(result);

    }


    @GetMapping(value = "{id}")
    public CustomerResource getCustomer(@PathVariable int id) {
        return customerResourceAssembler.toResource(customerService.getCustomer(id));
    }

}
