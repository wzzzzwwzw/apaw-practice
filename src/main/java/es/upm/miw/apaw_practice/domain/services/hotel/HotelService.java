package es.upm.miw.apaw_practice.domain.services.hotel;

import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import es.upm.miw.apaw_practice.domain.persistence_ports.hotel.HotelPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelPersistence hotelPersistence;

    @Autowired
    public HotelService(HotelPersistence hotelPersistence) {
        this.hotelPersistence = hotelPersistence;
    }

    public Hotel read(String name) {
        return this.hotelPersistence.readByName(name);
    }

    public Double MaxParticipantsAverageByEmail(String email) {
        return this.hotelPersistence.MaxParticipantAverageByEmail(email);
    }

    public List<Integer> distinctRoomNumbersByInstructor(String instructorName) {
        return this.hotelPersistence.distinctRoomNumbersByInstructor(instructorName);
    }
}
