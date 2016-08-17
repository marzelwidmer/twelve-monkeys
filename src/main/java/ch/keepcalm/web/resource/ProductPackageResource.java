package ch.keepcalm.web.resource;

import org.springframework.hateoas.ResourceSupport;

import java.math.BigDecimal;
import java.util.List;

public class ProductPackageResource extends ResourceSupport {

    private boolean bestPrice = false;


    // start product package stuff
    private BigDecimal bruttoPreis;
    private BigDecimal nettoPreis;

    private List<ProductResource> products;


    public boolean isBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(boolean bestPrice) {
        this.bestPrice = bestPrice;
    }

    public BigDecimal getBruttoPreis() {
        return bruttoPreis;
    }

    public void setBruttoPreis(BigDecimal bruttoPreis) {
        this.bruttoPreis = bruttoPreis;
    }

    public BigDecimal getNettoPreis() {
        return nettoPreis;
    }

    public void setNettoPreis(BigDecimal nettoPreis) {
        this.nettoPreis = nettoPreis;
    }

    public List<ProductResource> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResource> products) {
        this.products = products;
    }
}
