package es.upm.miw.apaw_practice.domain.persistence_ports.hotel;

import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelPersistence {
    Hotel readByName(String name);
}
