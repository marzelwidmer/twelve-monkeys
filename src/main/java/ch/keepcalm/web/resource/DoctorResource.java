package ch.keepcalm.web.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by marcelwidmer on 10/08/16.
 */
public class DoctorResource  extends ResourceSupport {

    @JsonProperty(value = "id")
    private String doctorId;
    private String avmNetz;
    private String avmNetzId;

    public DoctorResource() {
    }

    private DoctorResource(Builder builder) {
        setDoctorId(builder.id);
        setAvmNetz(builder.avmNetz);
        setAvmNetzId(builder.avmNetzId);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getAvmNetz() {
        return avmNetz;
    }

    public void setAvmNetz(String avmNetz) {
        this.avmNetz = avmNetz;
    }

    public String getAvmNetzId() {
        return avmNetzId;
    }

    public void setAvmNetzId(String avmNetzId) {
        this.avmNetzId = avmNetzId;
    }

    /**
     * {@code DoctorResource} builder static inner class.
     */
    public static final class Builder {
        private String id;
        private String avmNetz;
        private String avmNetzId;

        private Builder() {
        }

        /**
         * Sets the {@code id} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code id} to set
         * @return a reference to this Builder
         */
        public Builder Id(String val) {
            id = val;
            return this;
        }

        /**
         * Sets the {@code avmNetz} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code avmNetz} to set
         * @return a reference to this Builder
         */
        public Builder avmNetz(String val) {
            avmNetz = val;
            return this;
        }

        /**
         * Sets the {@code avmNetzId} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code avmNetzId} to set
         * @return a reference to this Builder
         */
        public Builder avmNetzId(String val) {
            avmNetzId = val;
            return this;
        }

        /**
         * Returns a {@code DoctorResource} built from the parameters previously set.
         *
         * @return a {@code DoctorResource} built with parameters of this {@code DoctorResource.Builder}
         */
        public DoctorResource build() {
            return new DoctorResource(this);
        }
    }

    @Override
    public String toString() {
        return "DoctorResource{" +
                "id='" + doctorId + '\'' +
                ", avmNetz='" + avmNetz + '\'' +
                ", avmNetzId='" + avmNetzId + '\'' +
                '}';
    }
}
