package ch.keepcalm.web.controller;

import ch.helsana.services.spezialfunktionen.tarif.v2.berechnepraemieresponse.Preis;
import ch.keepcalm.web.controller.assembler.CustomerResourceAssembler;
import ch.keepcalm.web.controller.assembler.ProductPackageResourceAssembler;
import ch.keepcalm.web.model.Customer;
import ch.keepcalm.web.model.ProductPackage;
import ch.keepcalm.web.resource.CustomerResource;
import ch.keepcalm.web.resource.ProductPackageResource;
import ch.keepcalm.web.service.CustomerService;
import ch.keepcalm.web.service.ProductPackagePriceService;
import ch.keepcalm.web.service.ProductPackageService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


@RestController
@RequestMapping(value = "/api/customers", produces = "application/hal+json")
public class CustomerController {

    private CustomerService customerService;
    ;
    private ProductPackageService productPackageService;
    private CustomerResourceAssembler customerResourceAssembler;
    private ProductPackageResourceAssembler productPackageResourceAssembler;

    private ProductPackagePriceService productPackagePriceService;


    @Autowired
    public void setCustomerController(CustomerService customerService, CustomerResourceAssembler customerResourceAssembler,
                                      ProductPackageService productPackageService,
                                      ProductPackageResourceAssembler productPackageResourceAssembler,
                                      ProductPackagePriceService productPackagePriceService) {
        this.customerService = customerService;
        this.customerResourceAssembler = customerResourceAssembler;

        this.productPackageService = productPackageService;
        this.productPackageResourceAssembler = productPackageResourceAssembler;

        this.productPackagePriceService = productPackagePriceService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CustomerResource postCustomer(@RequestBody CustomerResource customerResource) {

        Mapper mapper = new DozerBeanMapper();
        Customer destObject = mapper.map(customerResource, Customer.class);
        Customer result = customerService.createCustomer(destObject);

        return customerResourceAssembler.toResource(result);

    }

    @GetMapping(value = "{id}")
    public CustomerResource getCustomer(@PathVariable int id) {
        return customerResourceAssembler.toResource(customerService.getCustomer(id));
    }


    // TODO: 16/08/16 implement me... or refactor it in own controller class ?
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{id}/productpackage")
    public ProductPackageResource postProductPackage(@RequestBody ProductPackageResource productPackageResource, @PathVariable int id) {

        // FIXME: 17.08.2016 too much product packages Refactore it !
        Mapper mapper = new DozerBeanMapper();
        ProductPackage destObject = mapper.map(productPackageResource, ProductPackage.class);
        ProductPackage result = productPackageService.createProductPackage(destObject);

        Customer customer = customerService.getCustomer(id); // TODO: 17/08/16 update customer with product packages

        customer.getProductPackages().add(result);
        customerService.updateCustomer(customer);

        Link selfLink = new Link(linkTo(CustomerController.class)
                .slash(id)
                .slash("productpackage").slash(result.getId()).toUriComponentsBuilder().build().toUriString(), "self");
        productPackageResource.add(selfLink);


        Link updateProductPriceLink = new Link(linkTo(CustomerController.class)
                .slash(id)
                .slash("productpackage").slash(result.getId()).toUriComponentsBuilder().build().toUriString(), "updateProductpackage");
        productPackageResource.add(updateProductPriceLink);


        return productPackageResource; //customerResourceAssembler.toResource(result);

    }

    @GetMapping(value = "{id}/productpackage/{productPackageId}")
    public ProductPackageResource getProductPackage(@PathVariable int id, @PathVariable int productPackageId) {
        Customer customer = customerService.getCustomer(id);

        ProductPackage productPackage = productPackageService.getProductPackage(productPackageId);
        ProductPackageResource productPackageResource = productPackageResourceAssembler.toResource(productPackage);
        // TODO: 25/07/16 HATOAS LINKS
        updateProductPackageResourceLinks(id, productPackageId, productPackageResource);
        return productPackageResource;
    }


    @PatchMapping(value = "{id}/productpackage/{productPackageId}")
    public ProductPackageResource updateProductPackage(@PathVariable int id, @PathVariable int productPackageId) throws Exception {


        Customer customer = customerService.getCustomer(id);
        if (productPackageId >= 0 && (productPackageId <= customer.getProductPackages().size() - 1) && (customer.getProductPackages().size() > 0)) {
            ProductPackage productPackage = customer.getProductPackages().get(productPackageId);
            Preis price1 = productPackagePriceService.getPrice(customer, productPackage);
            customer.getProductPackages().get(productPackageId).setBruttoPreis(price1.getBruttoPreis());
            customer.getProductPackages().get(productPackageId).setNettoPreis(price1.getNettoPreis());
            Customer customer1 = customerService.updateCustomer(customer);
            System.out.println(customer1);
        }


       /*
        List<ProductPackage> productPackages = cus.getProductPackages();

        for (ProductPackage productPackage : productPackages) {
            if (productPackage.getId() == productPackageId){

                Preis price = productPackagePriceService.getPrice(cus, productPackage);
                // update price
              *//*  productPackage.setBruttoPreis(price.getBruttoPreis());
                productPackage.setNettoPreis(price.getNettoPreis());*//*
                productPackages.get(productPackageId).setBruttoPreis(price.getBruttoPreis());
                productPackages.get(productPackageId).setNettoPreis(price.getNettoPreis());
                // replace this updates package in list
                *//*cus.getProductPackages().remove(productPackage.getId());
                cus.getProductPackages().add(productPackage);*//*

                break;
            }
        }*/


        ProductPackage productPackage = productPackageService.getProductPackage(productPackageId);
        ProductPackageResource productPackageResource = productPackageResourceAssembler.toResource(productPackage);

        // call soap
        Preis price = productPackagePriceService.getPrice(customer, productPackage);

        // update
        Mapper mapper = new DozerBeanMapper();
        ProductPackage destObject = mapper.map(productPackageResource, ProductPackage.class);
        destObject.setBruttoPreis(price.getBruttoPreis());
        destObject.setNettoPreis(price.getNettoPreis());


        // TODO: 17.08.2016 Update Customer object ---
/*        customer.getProductPackages().add(destObject);
        Customer customer1 = customerService.updateCustomer(customer); // TODO: 17.08.2016  this make a new record... !!
        System.out.println(customer1);*/
        //destObject.setId(productPackageId);

        // ProductPackage updateProductPackage = productPackageService.updateProductPackage(destObject);

        ProductPackageResource updatedProductPackageResource = productPackageResourceAssembler.toResource(productPackage);


        // TODO: 25/07/16 HATOAS LINKS
        updateProductPackageResourceLinks(id, productPackageId, updatedProductPackageResource);

        return updatedProductPackageResource;
    }


    /**
     * @param id
     * @param productPackageId
     * @param productPackageResource
     */
    private void updateProductPackageResourceLinks(@PathVariable int id, @PathVariable int productPackageId, ProductPackageResource productPackageResource) {
        // TODO: 25/07/16 HATOAS LINKS
        Link selfLink = new Link(linkTo(CustomerController.class)
                .slash(id)
                .slash("productpackage").slash(productPackageId).toUriComponentsBuilder().build().toUriString(), "self");
        productPackageResource.add(selfLink);

        Link getSummary = new Link(linkTo(CustomerController.class)
                .slash(id)
                .slash("productpackage").slash(productPackageId).toUriComponentsBuilder().build().toUriString(), "getSummary");
        productPackageResource.add(getSummary);
    }


}
