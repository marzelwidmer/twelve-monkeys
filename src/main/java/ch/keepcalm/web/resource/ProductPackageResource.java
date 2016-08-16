package ch.keepcalm.web.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

public class ProductPackageResource extends ResourceSupport {
    private boolean bestPrice;
    private List<ProductResource> products;

    public boolean getBestPrice() {
        return this.bestPrice;
    }

    public void setBestPrice(boolean bestPrice) {
        this.bestPrice = bestPrice;
    }

    public List<ProductResource> getProducts() {
        return this.products;
    }

    public void setProducts(List<ProductResource> products) {
        this.products = products;
    }
}
