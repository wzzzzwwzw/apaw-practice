package es.upm.miw.apaw_practice.adapters.rest.hotel;

import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import es.upm.miw.apaw_practice.domain.services.hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(HotelResource.HOTELS)
public class HotelResource {
    static final String HOTELS = "/hotels";

    static final String HOTEL_NAME = "/{hotelName}";

    private final HotelService hotelService;

    @Autowired
    public HotelResource(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping(HOTEL_NAME)
    public Hotel read(@PathVariable String hotelName) {
        return this.hotelService.read(hotelName);
    }

}
