package ch.keepcalm.web.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

public class CustomerProductPackageResource extends ResourceSupport {
    private List<ProductResource> products;
    private String customerId;

    public List<ProductResource> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResource> products) {
        this.products = products;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
