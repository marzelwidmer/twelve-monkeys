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
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

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

    private BigDecimal price;
    private String unfall;
    private String franchise;
    private String drittesKind;
    private String description;
    private String produktId;
    private String avmNetz;
    private String eintrittsalter;
    private String ergaenzungsmodul;
    private String instanz;
    private String invaliditaetskapital;
    private String leistungsdauer;
    private String mutterschaft;
    private String todesfallkapital;
    private String unfallSistierung; // decimal
    private String variante;
    private String versicherterBetrag; // decimal
    private String versicherterBetragCode;



/*


    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductPackage> productPackages;
*/


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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduktId() {
        return produktId;
    }

    public void setProduktId(String produktId) {
        this.produktId = produktId;
    }

    public String getAvmNetz() {
        return avmNetz;
    }

    public void setAvmNetz(String avmNetz) {
        this.avmNetz = avmNetz;
    }

    public String getEintrittsalter() {
        return eintrittsalter;
    }

    public void setEintrittsalter(String eintrittsalter) {
        this.eintrittsalter = eintrittsalter;
    }

    public String getErgaenzungsmodul() {
        return ergaenzungsmodul;
    }

    public void setErgaenzungsmodul(String ergaenzungsmodul) {
        this.ergaenzungsmodul = ergaenzungsmodul;
    }

    public String getInstanz() {
        return instanz;
    }

    public void setInstanz(String instanz) {
        this.instanz = instanz;
    }

    public String getInvaliditaetskapital() {
        return invaliditaetskapital;
    }

    public void setInvaliditaetskapital(String invaliditaetskapital) {
        this.invaliditaetskapital = invaliditaetskapital;
    }

    public String getLeistungsdauer() {
        return leistungsdauer;
    }

    public void setLeistungsdauer(String leistungsdauer) {
        this.leistungsdauer = leistungsdauer;
    }

    public String getMutterschaft() {
        return mutterschaft;
    }

    public void setMutterschaft(String mutterschaft) {
        this.mutterschaft = mutterschaft;
    }

    public String getTodesfallkapital() {
        return todesfallkapital;
    }

    public void setTodesfallkapital(String todesfallkapital) {
        this.todesfallkapital = todesfallkapital;
    }

    public String getUnfallSistierung() {
        return unfallSistierung;
    }

    public void setUnfallSistierung(String unfallSistierung) {
        this.unfallSistierung = unfallSistierung;
    }

    public String getVariante() {
        return variante;
    }

    public void setVariante(String variante) {
        this.variante = variante;
    }

    public String getVersicherterBetrag() {
        return versicherterBetrag;
    }

    public void setVersicherterBetrag(String versicherterBetrag) {
        this.versicherterBetrag = versicherterBetrag;
    }

    public String getVersicherterBetragCode() {
        return versicherterBetragCode;
    }

    public void setVersicherterBetragCode(String versicherterBetragCode) {
        this.versicherterBetragCode = versicherterBetragCode;
    }

 /*   public List<ProductPackage> getProductPackages() {
        return productPackages;
    }

    public void setProductPackages(List<ProductPackage> productPackages) {
        this.productPackages = productPackages;
    }*/

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
        Product product = (Product) o;
        return getId() == product.getId() &&
                Objects.equals(getPrice(), product.getPrice()) &&
                Objects.equals(getUnfall(), product.getUnfall()) &&
                Objects.equals(getFranchise(), product.getFranchise()) &&
                Objects.equals(getDrittesKind(), product.getDrittesKind()) &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getProduktId(), product.getProduktId()) &&
                Objects.equals(getAvmNetz(), product.getAvmNetz()) &&
                Objects.equals(getEintrittsalter(), product.getEintrittsalter()) &&
                Objects.equals(getErgaenzungsmodul(), product.getErgaenzungsmodul()) &&
                Objects.equals(getInstanz(), product.getInstanz()) &&
                Objects.equals(getInvaliditaetskapital(), product.getInvaliditaetskapital()) &&
                Objects.equals(getLeistungsdauer(), product.getLeistungsdauer()) &&
                Objects.equals(getMutterschaft(), product.getMutterschaft()) &&
                Objects.equals(getTodesfallkapital(), product.getTodesfallkapital()) &&
                Objects.equals(getUnfallSistierung(), product.getUnfallSistierung()) &&
                Objects.equals(getVariante(), product.getVariante()) &&
                Objects.equals(getVersicherterBetrag(), product.getVersicherterBetrag()) &&
                Objects.equals(getVersicherterBetragCode(), product.getVersicherterBetragCode()) &&
               // Objects.equals(getProductPackages(), product.getProductPackages()) &&
                Objects.equals(getCreatedOn(), product.getCreatedOn()) &&
                Objects.equals(getUpdatedOn(), product.getUpdatedOn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getUnfall(), getFranchise(), getDrittesKind(), getDescription(), getProduktId(), getAvmNetz(), getEintrittsalter(), getErgaenzungsmodul(), getInstanz(), getInvaliditaetskapital(), getLeistungsdauer(), getMutterschaft(), getTodesfallkapital(), getUnfallSistierung(), getVariante(), getVersicherterBetrag(), getVersicherterBetragCode(),
               // getProductPackages(),
                getCreatedOn(), getUpdatedOn());
    }
}