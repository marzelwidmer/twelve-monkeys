package ch.keepcalm.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer implements Serializable {

    /*@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String gender;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;


    @ManyToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    private List<Product> products;



    @Temporal(TemporalType.TIMESTAMP)
    // TODO: 05.08.2016  RestDocs issue @Column(nullable = false, name = "CREATED_ON")
    @Column(nullable = true, name = "CREATED_ON")
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
    public Customer() {

    }

    private Customer(Builder builder) {
        this.id = builder.id;
        this.products = builder.products;
        this.dateOfBirth = builder.dateOfBirth;
        this.gender = builder.gender;
        this.address = builder.address;
    }

    public static Builder newCustomer() {
        return new Builder();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    /**
     * Getter for property 'dateOfBirth'.
     *
     * @return Value for property 'dateOfBirth'.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Setter for property 'dateOfBirth'.
     *
     * @param dateOfBirth Value to set for property 'dateOfBirth'.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Getter for property 'gender'.
     *
     * @return Value for property 'gender'.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Setter for property 'gender'.
     *
     * @param gender Value to set for property 'gender'.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Getter for property 'address'.
     *
     * @return Value for property 'address'.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Setter for property 'address'.
     *
     * @param address Value to set for property 'address'.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        if (products == null) {
            products = new ArrayList<>();
        } else {
            this.products.add(product);
        }
    }



    /**
     * {@code Customer} builder static inner class.
     */
    public static final class Builder {
        private int id;
        private List<Product> products;
        private Date dateOfBirth;
        private String gender;
        private Address address;

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
         * Sets the {@code products} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code products} to set
         * @return a reference to this Builder
         */
        public Builder products(List<Product> val) {
            products = val;
            return this;
        }

        /**
         * Returns a {@code Customer} built from the parameters previously set.
         *
         * @return a {@code Customer} built with parameters of this {@code Customer.Builder}
         */
        public Customer build() {
            return new Customer(this);
        }

        public Builder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }
    }
}
