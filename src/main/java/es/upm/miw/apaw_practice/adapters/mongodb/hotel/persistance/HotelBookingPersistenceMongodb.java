package es.upm.miw.apaw_practice.adapters.mongodb.hotel.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos.HotelBookingRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelBookingEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelBooking;
import es.upm.miw.apaw_practice.domain.persistence_ports.hotel.HotelBookingPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("hotelBookingPersistence")
public class HotelBookingPersistenceMongodb implements HotelBookingPersistence {

    private final HotelBookingRepository hotelBookingRepository;

    @Autowired
    public HotelBookingPersistenceMongodb(HotelBookingRepository hotelBookingRepository){
        this.hotelBookingRepository = hotelBookingRepository;
    }
    @Override
    public HotelBooking create(HotelBooking booking) {
        if(existsBooking(booking.getNumber()))
            throw new ConflictException("Booking number " + booking.getNumber() + " taken.");

        return this.hotelBookingRepository
                .save(new HotelBookingEntity(booking))
                .toObject();
    }

    @Override
    public boolean existsBooking(Integer bookingNumber) {
        return this.hotelBookingRepository
                .findByNumber(bookingNumber)
                .isPresent();
    }

}
