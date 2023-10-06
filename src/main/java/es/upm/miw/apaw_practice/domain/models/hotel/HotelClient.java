package es.upm.miw.apaw_practice.domain.models.hotel;

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

    public Boolean isPartner() {
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
}
