package ch.keepcalm.web.resource;

import ch.keepcalm.web.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;
import java.util.List;

public class CustomerResource extends ResourceSupport {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String gender;

    private AddressResource address;

    private List<Product> products;


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

    public AddressResource getAddress() {
        return address;
    }

    public void setAddress(AddressResource address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CustomerResource{" +
                "dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                ", products=" + products +
                '}';
    }
}