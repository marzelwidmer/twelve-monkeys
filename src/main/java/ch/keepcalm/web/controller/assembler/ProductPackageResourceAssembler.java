package ch.keepcalm.web.controller.assembler;

import ch.keepcalm.web.controller.CustomerController;
import ch.keepcalm.web.model.ProductPackage;
import ch.keepcalm.web.resource.ProductPackageResource;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ProductPackageResourceAssembler extends ResourceAssemblerSupport<ProductPackage, ProductPackageResource> {

    public ProductPackageResourceAssembler() {
        super(CustomerController.class, ProductPackageResource.class);
    }

    @Override
    public ProductPackageResource toResource(ProductPackage productPackage) {

        // api/customers/1; rel="self
        ProductPackageResource productPackageResource = createResourceWithId(productPackage.getId(), productPackage);

        Mapper mapper = new DozerBeanMapper();
        productPackageResource = mapper.map(productPackage, ProductPackageResource.class);



        return productPackageResource;
    }

}
