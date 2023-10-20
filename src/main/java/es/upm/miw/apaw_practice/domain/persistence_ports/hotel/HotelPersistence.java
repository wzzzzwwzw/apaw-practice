package es.upm.miw.apaw_practice.domain.persistence_ports.hotel;

import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import es.upm.miw.apaw_practice.domain.models.videogame_company.Videogame;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;


@Repository
public interface HotelPersistence {
    Hotel readByName(String name);

    Stream<Hotel> readAll();

    Double MaxParticipantAverageByEmail(String email);
}
