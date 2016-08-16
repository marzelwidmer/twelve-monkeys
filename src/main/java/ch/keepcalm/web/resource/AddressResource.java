package ch.keepcalm.web.resource;

import org.springframework.hateoas.ResourceSupport;

public class AddressResource  extends ResourceSupport {
    private String municipalityNr;
    private String postalCode;
    private String postalCodeAddition;
    private String municipality;
    private String locality;

    public AddressResource() {
    }

    private AddressResource(Builder builder) {
        setMunicipalityNr(builder.municipalityNr);
        setPostalCode(builder.postalCode);
        setPostalCodeAddition(builder.postalCodeAddition);
        setMunicipality(builder.municipality);
        setLocality(builder.locality);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getMunicipalityNr() {
        return municipalityNr;
    }

    public void setMunicipalityNr(String municipalityNr) {
        this.municipalityNr = municipalityNr;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCodeAddition() {
        return postalCodeAddition;
    }

    public void setPostalCodeAddition(String postalCodeAddition) {
        this.postalCodeAddition = postalCodeAddition;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }


    /**
     * {@code AddressResource} builder static inner class.
     */
    public static final class Builder {
        private String municipalityNr;
        private String postalCode;
        private String postalCodeAddition;
        private String municipality;
        private String locality;

        private Builder() {
        }

        /**
         * Sets the {@code municipalityNr} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code municipalityNr} to set
         * @return a reference to this Builder
         */
        public Builder municipalityNr(String val) {
            municipalityNr = val;
            return this;
        }

        /**
         * Sets the {@code postalCode} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code postalCode} to set
         * @return a reference to this Builder
         */
        public Builder postalCode(String val) {
            postalCode = val;
            return this;
        }

        /**
         * Sets the {@code postalCodeAddition} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code postalCodeAddition} to set
         * @return a reference to this Builder
         */
        public Builder postalCodeAddition(String val) {
            postalCodeAddition = val;
            return this;
        }

        /**
         * Sets the {@code municipality} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code municipality} to set
         * @return a reference to this Builder
         */
        public Builder municipality(String val) {
            municipality = val;
            return this;
        }

        /**
         * Sets the {@code locality} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code locality} to set
         * @return a reference to this Builder
         */
        public Builder locality(String val) {
            locality = val;
            return this;
        }

        /**
         * Returns a {@code AddressResource} built from the parameters previously set.
         *
         * @return a {@code AddressResource} built with parameters of this {@code AddressResource.Builder}
         */
        public AddressResource build() {
            return new AddressResource(this);
        }
    }

    @Override
    public String toString() {
        return "AddressResource{" +
                "municipalityNr='" + municipalityNr + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", postalCodeAddition='" + postalCodeAddition + '\'' +
                ", municipality='" + municipality + '\'' +
                ", locality='" + locality + '\'' +
                '}';
    }
}
