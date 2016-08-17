package ch.keepcalm.web.service;

import ch.keepcalm.web.model.ProductPackage;
import ch.keepcalm.web.repository.ProductPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPackageService {


    private ProductPackageRepository repository;

    @Autowired
    public void setProductPackageService(ProductPackageRepository repository) {
        this.repository = repository;
    }

    public ProductPackage createProductPackage(ProductPackage productPackage) {
        return repository.save(productPackage);
    }

    public ProductPackage getProductPackage(int id) {
        return repository.findOne(id);
    }

    public ProductPackage updateProductPackage(ProductPackage productPackage) {
 /*       ProductPackage one = repository.getOne(productPackage.getId());
        productPackage.setId(one.getId());*/
        return repository.save(productPackage);
    }
}
