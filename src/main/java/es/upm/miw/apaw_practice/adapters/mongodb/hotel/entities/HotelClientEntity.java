package es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities;

import es.upm.miw.apaw_practice.domain.models.hotel.HotelClient;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.UUID;

public class HotelClientEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String dni;
    private String email;
    private Integer telephone;
    private Boolean partnership;

    public HotelClientEntity() {
        // empty for framework
    }

    public HotelClientEntity(HotelClient client) {
        BeanUtils.copyProperties(client, this);
        this.id = UUID.randomUUID().toString();
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
