package ch.keepcalm.web.controller.assembler;

import ch.keepcalm.web.controller.CustomerController;
import ch.keepcalm.web.model.ProductPackage;
import ch.keepcalm.web.resource.ProductPackageResource;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.web.bind.annotation.ControllerAdvice;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@ControllerAdvice
public class ProductPackageResourceAssembler extends ResourceAssemblerSupport<ProductPackage, ProductPackageResource> {

    public ProductPackageResourceAssembler() {
        super(CustomerController.class, ProductPackageResource.class);
    }

    @Override
    public ProductPackageResource toResource(ProductPackage productPackage) {
        Mapper mapper = new DozerBeanMapper();
        ProductPackageResource productPackageResource = mapper.map(productPackage, ProductPackageResource.class);

        // TODO: 17/08/16 fixMe !! 
        Link self = new Link(linkTo(CustomerController.class)
                .slash(productPackage.getId())
                .toUriComponentsBuilder().build().toUriString(), "self");
        productPackageResource.add(self);

        // TODO: 17/08/16 Resouce fuer deepLink (this package und customer)


        return productPackageResource;
    }

}
