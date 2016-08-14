package ch.keepcalm.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by marcelwidmer on 10/07/16.
 */
@Entity
public class Address  implements Serializable {

    /*@Id
     @GeneratedValue(generator = "system-uuid")
     @GenericGenerator(name = "system-uuid", strategy = "uuid")
     private String id;*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String municipality;  // ": "Dübendorf", /* Gemeindename */
    private String municipalityNr;  //": 191, /* Gemeinde-Nr */
    private String postalCode; // ": 8044, /* Postleitzahl */
    private String postalCodeAddition; // ": 00, /* postleitzahlZusatz */
    private String locality; //": "Gockhausen" /* Ort */


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
    public Address() {}

    private Address(Builder builder) {
        this.municipality = builder.municipality;
        this.municipalityNr = builder.municipality_nr;
        this.postalCode = builder.postal_code;
        this.postalCodeAddition = builder.postalCodeAddition;
        this.locality = builder.locality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
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

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public static Builder newAddress() {
        return new Builder();
    }


    public static final class Builder {
        private String municipality;
        private String municipality_nr;
        private String postal_code;
        private String postalCodeAddition;
        private String locality;

        private Builder() {
        }

        public Address build() {
            return new Address(this);
        }

        public Builder municipality(String municipality) {
            this.municipality = municipality;
            return this;
        }

        public Builder municipalityNr(String municipalityNr) {
            this.municipality_nr = municipalityNr;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postal_code = postalCode;
            return this;
        }

        public Builder postalCodeAddition(String postalCodeAddition) {
            this.postalCodeAddition = postalCodeAddition;
            return this;
        }

        public Builder locality(String locality) {
            this.locality = locality;
            return this;
        }
    }
}
