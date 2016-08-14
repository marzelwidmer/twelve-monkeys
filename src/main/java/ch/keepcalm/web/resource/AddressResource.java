package ch.keepcalm.web.resource;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by marcelwidmer on 14/08/16.
 */
public class AddressResource extends ResourceSupport {


    private String municipality;  // ": "Dübendorf", /* Gemeindename */
    private String municipalityNr;  //": 191, /* Gemeinde-Nr */
    private String postalCode; // ": 8044, /* Postleitzahl */
    private String postalCodeAddition; // ": 00, /* postleitzahlZusatz */
    private String locality; //": "Gockhausen" /* Ort */


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

    @Override
    public String toString() {
        return "AddressResource{" +
                "municipality='" + municipality + '\'' +
                ", municipalityNr='" + municipalityNr + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", postalCodeAddition='" + postalCodeAddition + '\'' +
                ", locality='" + locality + '\'' +
                '}';
    }
}
