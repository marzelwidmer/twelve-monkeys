package ch.keepcalm.web.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;
import java.util.List;

public class CustomerResource extends ResourceSupport {
    private boolean bestPrice = false;

    private AddressResource address;
    private String gender;
    private Date dateOfBirth;

    @JsonProperty(value="id")
    private String customerId;
    private List<ProductResource> products;


    public CustomerResource() {
    }

    private CustomerResource(Builder builder) {
        setBestPrice(builder.bestPrice);
        setAddress(builder.address);
        setGender(builder.gender);
        setDateOfBirth(builder.dateOfBirth);
        setCustomerId(builder.customerId);
        setProducts(builder.products);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean isBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(boolean bestPrice) {
        this.bestPrice = bestPrice;
    }

    public AddressResource getAddress() {
        return address;
    }

    public void setAddress(AddressResource address) {
        this.address = address;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<ProductResource> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResource> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CustomerResource{" +
                "bestPrice=" + bestPrice +
                ", address=" + address +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", customerId='" + customerId + '\'' +
                ", products=" + products +
                '}';
    }


    /**
     * {@code CustomerResource} builder static inner class.
     */
    public static final class Builder {
        private boolean bestPrice;
        private AddressResource address;
        private String gender;
        private Date dateOfBirth;
        private String customerId;
        private List<ProductResource> products;

        private Builder() {
        }

        /**
         * Sets the {@code bestPrice} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code bestPrice} to set
         * @return a reference to this Builder
         */
        public Builder bestPrice(boolean val) {
            bestPrice = val;
            return this;
        }

        /**
         * Sets the {@code address} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code address} to set
         * @return a reference to this Builder
         */
        public Builder address(AddressResource val) {
            address = val;
            return this;
        }

        /**
         * Sets the {@code gender} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code gender} to set
         * @return a reference to this Builder
         */
        public Builder gender(String val) {
            gender = val;
            return this;
        }

        /**
         * Sets the {@code dateOfBirth} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code dateOfBirth} to set
         * @return a reference to this Builder
         */
        public Builder dateOfBirth(Date val) {
            dateOfBirth = val;
            return this;
        }

        /**
         * Sets the {@code customerId} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code customerId} to set
         * @return a reference to this Builder
         */
        public Builder customerId(String val) {
            customerId = val;
            return this;
        }

        /**
         * Sets the {@code products} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code products} to set
         * @return a reference to this Builder
         */
        public Builder products(List<ProductResource> val) {
            products = val;
            return this;
        }

        /**
         * Returns a {@code CustomerResource} built from the parameters previously set.
         *
         * @return a {@code CustomerResource} built with parameters of this {@code CustomerResource.Builder}
         */
        public CustomerResource build() {
            return new CustomerResource(this);
        }
    }
}