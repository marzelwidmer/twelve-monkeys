package ch.keepcalm.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class ProductPackage implements Serializable {


    /*@Id
     @GeneratedValue(generator = "system-uuid")
     @GenericGenerator(name = "system-uuid", strategy = "uuid")
     private String id;*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private boolean bestPrice = false;
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


    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;


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
    public ProductPackage() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(boolean bestPrice) {
        this.bestPrice = bestPrice;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
        return "ProductPackage{" +
                "id=" + id +
                ", bestPrice=" + bestPrice +
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
                ", products=" + products +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}