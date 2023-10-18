package es.upm.miw.apaw_practice.domain.services.hotel;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelBookingEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.hospital.Doctor;
import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelBooking;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import es.upm.miw.apaw_practice.domain.persistence_ports.hotel.HotelBookingPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.hotel.HotelPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelBookingService {

    private final HotelBookingPersistence hotelBookingPersistence;

    @Autowired
    public HotelBookingService(HotelBookingPersistence hotelBookingPersistence) {
        this.hotelBookingPersistence = hotelBookingPersistence;
    }

    public HotelBooking create(HotelBooking booking) {
        this.assertNumberNotExist(booking.getNumber());
        return this.hotelBookingPersistence.create(booking);
    }

    private void assertNumberNotExist(Integer number) {
        if (this.hotelBookingPersistence.existsBooking(number)) {
            throw new ConflictException("Booking number taken: " + number);
        }
    }
}
