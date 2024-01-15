package es.upm.miw.apaw_practice.adapters.rest.hotel;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import es.upm.miw.apaw_practice.domain.services.hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(HotelResource.HOTELS)
public class HotelResource {
    static final String HOTELS = "/hotels";

    static final String HOTEL_NAME = "/{hotelName}";

    static final String SEARCH_MAX_PARTICIPANTS = "/searchMaxParticipants";

    static final String SEARCH_ROOMS_NUMBERS = "/searchRoomNumbers";

    private final HotelService hotelService;

    @Autowired
    public HotelResource(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping(HOTEL_NAME)
    public Hotel read(@PathVariable String hotelName) {
        return this.hotelService.read(hotelName);
    }

    @GetMapping(SEARCH_MAX_PARTICIPANTS)
    public Double MaxParticipantsSumByEmail(@RequestParam String q) {
        String email = String.valueOf(new LexicalAnalyzer().extractWithAssure(q, "email"));
        return this.hotelService.MaxParticipantsAverageByEmail(email);
    }

    @GetMapping(SEARCH_ROOMS_NUMBERS)
    public List<Integer> distinctRoomNumbersByInstructor(@RequestParam String q) {
        String instructorName = String.valueOf(new LexicalAnalyzer().extractWithAssure(q, "instructorName"));
        return this.hotelService.distinctRoomNumbersByInstructor(instructorName);
    }

}
