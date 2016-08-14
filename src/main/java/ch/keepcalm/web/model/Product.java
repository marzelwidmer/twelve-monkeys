package ch.keepcalm.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by marcelwidmer on 21/03/16.
 */
@Entity
public class Product implements Serializable {


    /*@Id
     @GeneratedValue(generator = "system-uuid")
     @GenericGenerator(name = "system-uuid", strategy = "uuid")
     private String id;*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //@Size(min = 2, max = 30)
    private String description;

    //@Size(min = 1, max = 36)
    private String productNumber;
    private String unfall;
    private String franchise;
    private String drittesKind;
    private BigDecimal price;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<Customer> customer;


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
    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnfall() {
        return unfall;
    }

    public void setUnfall(String unfall) {
        this.unfall = unfall;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public String getDrittesKind() {
        return drittesKind;
    }

    public void setDrittesKind(String drittesKind) {
        this.drittesKind = drittesKind;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

     private Product(Builder builder) {
        id = builder.id;
        productNumber = builder.productNumber;
        description = builder.description;
        unfall = builder.unfall;
        franchise = builder.franchise;
        drittesKind = builder.drittesKind;
        price = builder.price;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    /**
     * {@code Product} builder static inner class.
     */
    public static final class Builder {
        private int id;
        private String productNumber;
        private String description;
        private String unfall;
        private String franchise;
        private String drittesKind;
        private BigDecimal price;
        private Customer customer;

        private Builder() {
        }

        /**
         * Sets the {@code id} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code id} to set
         * @return a reference to this Builder
         */
        public Builder id(int val) {
            id = val;
            return this;
        }

        /**
         * Sets the {@code productNumber} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code productNumber} to set
         * @return a reference to this Builder
         */
        public Builder productNumber(String val) {
            productNumber = val;
            return this;
        }

        /**
         * Sets the {@code description} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code description} to set
         * @return a reference to this Builder
         */
        public Builder description(String val) {
            description = val;
            return this;
        }

        /**
         * Sets the {@code unfall} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code unfall} to set
         * @return a reference to this Builder
         */
        public Builder unfall(String val) {
            unfall = val;
            return this;
        }

        /**
         * Sets the {@code franchise} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code franchise} to set
         * @return a reference to this Builder
         */
        public Builder franchise(String val) {
            franchise = val;
            return this;
        }

        /**
         * Sets the {@code drittesKind} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code drittesKind} to set
         * @return a reference to this Builder
         */
        public Builder drittesKind(String val) {
            drittesKind = val;
            return this;
        }

        /**
         * Sets the {@code price} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code price} to set
         * @return a reference to this Builder
         */
        public Builder price(BigDecimal val) {
            price = val;
            return this;
        }

        /**
         * Sets the {@code customer} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code customer} to set
         * @return a reference to this Builder
         */
        public Builder customer(Customer val) {
            customer = val;
            return this;
        }

        /**
         * Returns a {@code Product} built from the parameters previously set.
         *
         * @return a {@code Product} built with parameters of this {@code Product.Builder}
         */
        public Product build() {
            return new Product(this);
        }
    }
}