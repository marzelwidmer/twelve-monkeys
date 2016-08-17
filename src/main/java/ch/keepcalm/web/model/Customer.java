package ch.keepcalm.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer implements Serializable {

    /*@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date dateOfBirth;
    private String gender;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;


   /* @ManyToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    private List<Product> products;*/

    @ManyToMany(targetEntity = ProductPackage.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductPackage> productPackages;




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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<ProductPackage> getProductPackages() {
        return productPackages;
    }

    public void setProductPackages(List<ProductPackage> productPackages) {
        this.productPackages = productPackages;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getId() == customer.getId() &&
                Objects.equals(getDateOfBirth(), customer.getDateOfBirth()) &&
                Objects.equals(getGender(), customer.getGender()) &&
                Objects.equals(getAddress(), customer.getAddress()) &&
                Objects.equals(getProductPackages(), customer.getProductPackages()) &&
                Objects.equals(getCreatedOn(), customer.getCreatedOn()) &&
                Objects.equals(getUpdatedOn(), customer.getUpdatedOn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateOfBirth(), getGender(), getAddress(), getProductPackages(), getCreatedOn(), getUpdatedOn());
    }
}
