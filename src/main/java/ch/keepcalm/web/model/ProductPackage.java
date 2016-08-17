package ch.keepcalm.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by marcelwidmer on 21/03/16.
 */
@Entity
public class ProductPackage implements Serializable {


    /*@Id
     @GeneratedValue(generator = "system-uuid")
     @GenericGenerator(name = "system-uuid", strategy = "uuid")
     private String id;*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private boolean bestPrice = false;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "CREATED_ON")
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "UPDATED_ON")
    private Date updatedOn;

    @PrePersist
    protected void onCreate() {
        createdOn = new Date();
        updatedOn = createdOn;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedOn = new Date();
    }


    /**
     * Used for Entity
     */
    public ProductPackage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(boolean bestPrice) {
        this.bestPrice = bestPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "ProductPackage{" +
                "id=" + id +
                ", bestPrice=" + bestPrice +
                ", products=" + products +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}