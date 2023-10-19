package es.upm.miw.apaw_practice.adapters.rest.hotel;

import es.upm.miw.apaw_practice.domain.models.hotel.HotelActivity;
import es.upm.miw.apaw_practice.domain.services.hotel.HotelActivityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(HotelResource.HOTELS + HotelActivityResource.ACTIVITIES)
public class HotelActivityResource {

    static final String ACTIVITIES = "/activities";

    static final String ACTIVITY_NAME = "/{activityName}";

    private final HotelActivityService hotelActivityService;

    public HotelActivityResource(HotelActivityService hotelActivityService) {
        this.hotelActivityService = hotelActivityService;
    }

    @PatchMapping(ACTIVITY_NAME)
    public HotelActivity updateInstructor(@PathVariable String activityName, @RequestBody String newInstructor) {
        return this.hotelActivityService.updateInstructor(activityName, newInstructor);
    }
}
