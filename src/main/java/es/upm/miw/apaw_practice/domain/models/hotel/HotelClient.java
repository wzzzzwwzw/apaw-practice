package es.upm.miw.apaw_practice.domain.models.hotel;

import es.upm.miw.apaw_practice.domain.models.hotel.buiders.HotelClientBuilder;

public class HotelClient {
    private String dni;
    private String email;
    private Integer telephone;
    private Boolean partnership;

    public HotelClient(String dni, String email, Integer telephone, Boolean partnership) {
        this.dni = dni;
        this.email = email;
        this.telephone = telephone;
        this.partnership = partnership;
    }

    public HotelClient() {
        // empty for framework
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Boolean getPartnership() {
        return partnership;
    }

    public void setPartnership(Boolean newPartnership) {
        this.partnership = newPartnership;
    }

    @Override
    public String toString() {
        return "HotelClient {" + '\'' +
                "  dni = '" + dni + '\'' +
                "  email = '" + email + '\'' +
                "  telephone = " + telephone + '\'' +
                "  partnership = " + partnership + '\'' +
                '}';
    }

    public static class Builder implements HotelClientBuilder.DNI, HotelClientBuilder.Email,
            HotelClientBuilder.Telephone, HotelClientBuilder.Partnership,
            HotelClientBuilder.Build {
        private final HotelClient client;

        public Builder() {
            this.client = new HotelClient();
        }

        @Override
        public HotelClientBuilder.Email dni(String dni) {
            this.client.setDni(dni);
            return this;
        }

        @Override
        public HotelClientBuilder.Telephone email(String email) {
            this.client.setEmail(email);
            return this;
        }

        @Override
        public HotelClientBuilder.Partnership telephone(Integer telephone) {
            this.client.setTelephone(telephone);
            return this;
        }

        @Override
        public HotelClientBuilder.Build partnership(Boolean partnership) {
            this.client.setPartnership(partnership);
            return this;
        }

        @Override
        public HotelClient build() {
            return this.client;
        }
    }
}
