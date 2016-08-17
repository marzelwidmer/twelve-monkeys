package ch.keepcalm.web.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

public class CustomerProductPackageResource extends ResourceSupport {

    private boolean bestPrice = false;

    private List<ProductResource> products;

    public List<ProductResource> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResource> products) {
        this.products = products;
    }

    public boolean isBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(boolean bestPrice) {
        this.bestPrice = bestPrice;
    }
}
