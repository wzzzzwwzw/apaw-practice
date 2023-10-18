package es.upm.miw.apaw_practice.adapters.rest.hotel;

import es.upm.miw.apaw_practice.domain.models.hotel.HotelBooking;
import es.upm.miw.apaw_practice.domain.services.hotel.HotelBookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(HotelResource.HOTELS + HotelBookingResource.BOOKINGS)
public class HotelBookingResource {

    static final String BOOKINGS = "/bookings";

    private final HotelBookingService hotelBookingService;

    public HotelBookingResource(HotelBookingService hotelBookingService) {
        this.hotelBookingService = hotelBookingService;
    }

    @PostMapping
    public HotelBooking create(@RequestBody HotelBooking booking) {
        return this.hotelBookingService.create(booking);
    }
}
