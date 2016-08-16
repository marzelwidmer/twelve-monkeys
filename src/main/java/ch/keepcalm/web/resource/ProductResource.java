package ch.keepcalm.web.resource;

import org.springframework.hateoas.ResourceSupport;

import java.math.BigDecimal;

public class ProductResource  extends ResourceSupport {

    private BigDecimal price;
    private String unfall;
    private String franchise;
    private String drittesKind;
    private String description;
    private String produktId;
    private DoctorResource arzt;
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

    public ProductResource() {
    }

    private ProductResource(Builder builder) {
        setPrice(builder.price);
        setUnfall(builder.unfall);
        setFranchise(builder.franchise);
        setDrittesKind(builder.drittesKind);
        setDescription(builder.description);
        setProduktId(builder.produktId);
        setArzt(builder.arzt);
        setEintrittsalter(builder.eintrittsalter);
        setErgaenzungsmodul(builder.ergaenzungsmodul);
        setInstanz(builder.instanz);
        setInvaliditaetskapital(builder.invaliditaetskapital);
        setLeistungsdauer(builder.leistungsdauer);
        setMutterschaft(builder.mutterschaft);
        setTodesfallkapital(builder.todesfallkapital);
        setUnfallSistierung(builder.unfallSistierung);
        setVariante(builder.variante);
        setVersicherterBetrag(builder.versicherterBetrag);
        setVersicherterBetragCode(builder.versicherterBetragCode);
    }

    public static Builder newBuilder() {
        return new Builder();
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

    public DoctorResource getArzt() {
        return arzt;
    }

    public void setArzt(DoctorResource arzt) {
        this.arzt = arzt;
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

    @Override
    public String toString() {
        return "ProductResource{" +
                "price=" + price +
                ", unfall='" + unfall + '\'' +
                ", franchise='" + franchise + '\'' +
                ", drittesKind='" + drittesKind + '\'' +
                ", description='" + description + '\'' +
                ", produktId='" + produktId + '\'' +
                ", arzt=" + arzt +
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
                '}';
    }

    /**
     * {@code ProductResource} builder static inner class.
     */
    public static final class Builder {
        private BigDecimal price;
        private String unfall;
        private String franchise;
        private String drittesKind;
        private String description;
        private String produktId;
        private DoctorResource arzt;
        private String eintrittsalter;
        private String ergaenzungsmodul;
        private String instanz;
        private String invaliditaetskapital;
        private String leistungsdauer;
        private String mutterschaft;
        private String todesfallkapital;
        private String unfallSistierung;
        private String variante;
        private String versicherterBetrag;
        private String versicherterBetragCode;

        private Builder() {
        }

        /**
         * Sets the {@code price} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code price} to set
         * @return a reference to this Builder
         */
        public Builder price(BigDecimal val) {
            price = val;
            return this;
        }

        /**
         * Sets the {@code unfall} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code unfall} to set
         * @return a reference to this Builder
         */
        public Builder unfall(String val) {
            unfall = val;
            return this;
        }

        /**
         * Sets the {@code franchise} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code franchise} to set
         * @return a reference to this Builder
         */
        public Builder franchise(String val) {
            franchise = val;
            return this;
        }

        /**
         * Sets the {@code drittesKind} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code drittesKind} to set
         * @return a reference to this Builder
         */
        public Builder drittesKind(String val) {
            drittesKind = val;
            return this;
        }

        /**
         * Sets the {@code description} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code description} to set
         * @return a reference to this Builder
         */
        public Builder description(String val) {
            description = val;
            return this;
        }

        /**
         * Sets the {@code produktId} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code produktId} to set
         * @return a reference to this Builder
         */
        public Builder produktId(String val) {
            produktId = val;
            return this;
        }

        /**
         * Sets the {@code arzt} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code arzt} to set
         * @return a reference to this Builder
         */
        public Builder arzt(DoctorResource val) {
            arzt = val;
            return this;
        }

        /**
         * Sets the {@code eintrittsalter} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code eintrittsalter} to set
         * @return a reference to this Builder
         */
        public Builder eintrittsalter(String val) {
            eintrittsalter = val;
            return this;
        }

        /**
         * Sets the {@code ergaenzungsmodul} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code ergaenzungsmodul} to set
         * @return a reference to this Builder
         */
        public Builder ergaenzungsmodul(String val) {
            ergaenzungsmodul = val;
            return this;
        }

        /**
         * Sets the {@code instanz} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code instanz} to set
         * @return a reference to this Builder
         */
        public Builder instanz(String val) {
            instanz = val;
            return this;
        }

        /**
         * Sets the {@code invaliditaetskapital} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code invaliditaetskapital} to set
         * @return a reference to this Builder
         */
        public Builder invaliditaetskapital(String val) {
            invaliditaetskapital = val;
            return this;
        }

        /**
         * Sets the {@code leistungsdauer} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code leistungsdauer} to set
         * @return a reference to this Builder
         */
        public Builder leistungsdauer(String val) {
            leistungsdauer = val;
            return this;
        }

        /**
         * Sets the {@code mutterschaft} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code mutterschaft} to set
         * @return a reference to this Builder
         */
        public Builder mutterschaft(String val) {
            mutterschaft = val;
            return this;
        }

        /**
         * Sets the {@code todesfallkapital} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code todesfallkapital} to set
         * @return a reference to this Builder
         */
        public Builder todesfallkapital(String val) {
            todesfallkapital = val;
            return this;
        }

        /**
         * Sets the {@code unfallSistierung} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code unfallSistierung} to set
         * @return a reference to this Builder
         */
        public Builder unfallSistierung(String val) {
            unfallSistierung = val;
            return this;
        }

        /**
         * Sets the {@code variante} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code variante} to set
         * @return a reference to this Builder
         */
        public Builder variante(String val) {
            variante = val;
            return this;
        }

        /**
         * Sets the {@code versicherterBetrag} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code versicherterBetrag} to set
         * @return a reference to this Builder
         */
        public Builder versicherterBetrag(String val) {
            versicherterBetrag = val;
            return this;
        }

        /**
         * Sets the {@code versicherterBetragCode} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code versicherterBetragCode} to set
         * @return a reference to this Builder
         */
        public Builder versicherterBetragCode(String val) {
            versicherterBetragCode = val;
            return this;
        }

        /**
         * Returns a {@code ProductResource} built from the parameters previously set.
         *
         * @return a {@code ProductResource} built with parameters of this {@code ProductResource.Builder}
         */
        public ProductResource build() {
            return new ProductResource(this);
        }
    }
}
