package es.upm.miw.apaw_practice.domain.persistence_ports.hotel;

import es.upm.miw.apaw_practice.domain.models.hotel.HotelBooking;

public interface HotelBookingPersistence {
    HotelBooking create(HotelBooking booking);

    boolean existsBooking(Integer bookingNumber);
}
