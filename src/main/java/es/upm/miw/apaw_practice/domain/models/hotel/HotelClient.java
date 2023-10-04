package es.upm.miw.apaw_practice.domain.models.hotel;

public class HotelClient {
    private String dni;
    private String email;
    private int telephone;
    private boolean partnership;

    public HotelClient(String dni, String email, int telephone, boolean partnership) {
        this.dni = dni;
        this.email = email;
        this.telephone = telephone;
        this.partnership = partnership;
    }

    public HotelClient() {
        dni = "00000000A";
        email = "email@email.com";
        telephone = 0;
        partnership = false;
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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public boolean isPartner() {
        return partnership;
    }

    public void setPartnership(boolean newPartnership) {
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
