package ch.keepcalm.web.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

public class CustomerResource extends ResourceSupport {


    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @JsonProperty(value="address")
    private AddressResource address;

    public CustomerResource() {
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public AddressResource getAddress() {
        return address;
    }

    public void setAddress(AddressResource address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerResource{" +
                "gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                '}';
    }
}