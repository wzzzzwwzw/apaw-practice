package es.upm.miw.apaw_practice.adapters.rest.hotel;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import es.upm.miw.apaw_practice.domain.services.hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(HotelResource.HOTELS)
public class HotelResource {
    static final String HOTELS = "/hotels";

    static final String HOTEL_NAME = "/{hotelName}";

    static final String SEARCH = "/search";

    private final HotelService hotelService;

    @Autowired
    public HotelResource(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping(HOTEL_NAME)
    public Hotel read(@PathVariable String hotelName) {
        return this.hotelService.read(hotelName);
    }

    @GetMapping(SEARCH)
    public Double MaxParticipantsSumByEmail(@RequestParam String q) {
        String email = String.valueOf(new LexicalAnalyzer().extractWithAssure(q, "email"));
        return this.hotelService.MaxParticipantsAverageByEmail(email);
    }

}
