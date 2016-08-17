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



    // start product package stuff
    private BigDecimal bruttoPreis;
    private BigDecimal nettoPreis;
    private BigDecimal kvg106Betrag;
    private BigDecimal umweltabgabeBetrag;
    private Boolean drittesKindPraemie;
    private BigDecimal einjahrgratisBetrag;
    private BigDecimal familienrabattBetrag;
    private BigDecimal kinderJugendrabattBetrag;
    private BigDecimal kinderStartrabattBetrag;
    private BigDecimal kollektivrabatt;
    private BigDecimal kombinationsrabattBetrag;
    private BigDecimal mehrjahresvertragBetrag;
    private BigDecimal partnerrabattBetrag;
    private BigDecimal ueberrabattierungBetrag;

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

    public BigDecimal getBruttoPreis() {
        return bruttoPreis;
    }

    public void setBruttoPreis(BigDecimal bruttoPreis) {
        this.bruttoPreis = bruttoPreis;
    }

    public BigDecimal getNettoPreis() {
        return nettoPreis;
    }

    public void setNettoPreis(BigDecimal nettoPreis) {
        this.nettoPreis = nettoPreis;
    }

    public BigDecimal getKvg106Betrag() {
        return kvg106Betrag;
    }

    public void setKvg106Betrag(BigDecimal kvg106Betrag) {
        this.kvg106Betrag = kvg106Betrag;
    }

    public BigDecimal getUmweltabgabeBetrag() {
        return umweltabgabeBetrag;
    }

    public void setUmweltabgabeBetrag(BigDecimal umweltabgabeBetrag) {
        this.umweltabgabeBetrag = umweltabgabeBetrag;
    }

    public Boolean getDrittesKindPraemie() {
        return drittesKindPraemie;
    }

    public void setDrittesKindPraemie(Boolean drittesKindPraemie) {
        this.drittesKindPraemie = drittesKindPraemie;
    }

    public BigDecimal getEinjahrgratisBetrag() {
        return einjahrgratisBetrag;
    }

    public void setEinjahrgratisBetrag(BigDecimal einjahrgratisBetrag) {
        this.einjahrgratisBetrag = einjahrgratisBetrag;
    }

    public BigDecimal getFamilienrabattBetrag() {
        return familienrabattBetrag;
    }

    public void setFamilienrabattBetrag(BigDecimal familienrabattBetrag) {
        this.familienrabattBetrag = familienrabattBetrag;
    }

    public BigDecimal getKinderJugendrabattBetrag() {
        return kinderJugendrabattBetrag;
    }

    public void setKinderJugendrabattBetrag(BigDecimal kinderJugendrabattBetrag) {
        this.kinderJugendrabattBetrag = kinderJugendrabattBetrag;
    }

    public BigDecimal getKinderStartrabattBetrag() {
        return kinderStartrabattBetrag;
    }

    public void setKinderStartrabattBetrag(BigDecimal kinderStartrabattBetrag) {
        this.kinderStartrabattBetrag = kinderStartrabattBetrag;
    }

    public BigDecimal getKollektivrabatt() {
        return kollektivrabatt;
    }

    public void setKollektivrabatt(BigDecimal kollektivrabatt) {
        this.kollektivrabatt = kollektivrabatt;
    }

    public BigDecimal getKombinationsrabattBetrag() {
        return kombinationsrabattBetrag;
    }

    public void setKombinationsrabattBetrag(BigDecimal kombinationsrabattBetrag) {
        this.kombinationsrabattBetrag = kombinationsrabattBetrag;
    }

    public BigDecimal getMehrjahresvertragBetrag() {
        return mehrjahresvertragBetrag;
    }

    public void setMehrjahresvertragBetrag(BigDecimal mehrjahresvertragBetrag) {
        this.mehrjahresvertragBetrag = mehrjahresvertragBetrag;
    }

    public BigDecimal getPartnerrabattBetrag() {
        return partnerrabattBetrag;
    }

    public void setPartnerrabattBetrag(BigDecimal partnerrabattBetrag) {
        this.partnerrabattBetrag = partnerrabattBetrag;
    }

    public BigDecimal getUeberrabattierungBetrag() {
        return ueberrabattierungBetrag;
    }

    public void setUeberrabattierungBetrag(BigDecimal ueberrabattierungBetrag) {
        this.ueberrabattierungBetrag = ueberrabattierungBetrag;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
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
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", unfall='" + unfall + '\'' +
                ", franchise='" + franchise + '\'' +
                ", drittesKind='" + drittesKind + '\'' +
                ", description='" + description + '\'' +
                ", produktId='" + produktId + '\'' +
                ", avmNetz='" + avmNetz + '\'' +
                ", eintrittsalter='" + eintrittsalter + '\'' +
                ", ergaenzungsmodul='" + ergaenzungsmodul + '\'' +
                ", instanz='" + instanz + '\'' +
                ", invaliditaetskapital='" + invaliditaetskapital + '\'' +
                ", leistungsdauer='" + leistungsdauer + '\'' +
                ", mutterschaft='" + mutterschaft + '\'' +
                ", todesfallkapital='" + todesfallkapital + '\'' +
                ", unfallSistierung='" + unfallSistierung + '\'' +
                ", variante='" + variante + '\'' +
                ", versicherterBetrag='" + versicherterBetrag + '\'' +
                ", versicherterBetragCode='" + versicherterBetragCode + '\'' +
                ", bruttoPreis=" + bruttoPreis +
                ", nettoPreis=" + nettoPreis +
                ", kvg106Betrag=" + kvg106Betrag +
                ", umweltabgabeBetrag=" + umweltabgabeBetrag +
                ", drittesKindPraemie=" + drittesKindPraemie +
                ", einjahrgratisBetrag=" + einjahrgratisBetrag +
                ", familienrabattBetrag=" + familienrabattBetrag +
                ", kinderJugendrabattBetrag=" + kinderJugendrabattBetrag +
                ", kinderStartrabattBetrag=" + kinderStartrabattBetrag +
                ", kollektivrabatt=" + kollektivrabatt +
                ", kombinationsrabattBetrag=" + kombinationsrabattBetrag +
                ", mehrjahresvertragBetrag=" + mehrjahresvertragBetrag +
                ", partnerrabattBetrag=" + partnerrabattBetrag +
                ", ueberrabattierungBetrag=" + ueberrabattierungBetrag +
                ", customer=" + customer +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}