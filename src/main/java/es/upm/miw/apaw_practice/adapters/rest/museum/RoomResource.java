package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Room;
import es.upm.miw.apaw_practice.domain.services.museum.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RoomResource.ROOMS)
public class RoomResource {
    static final String ROOMS = "/museum/rooms";
    static final String DESCRIPTION_ID = "/{description}";

    private final RoomService roomService;

    @Autowired
    public RoomResource(RoomService roomService) {
        this.roomService = roomService;
    }

    @PatchMapping(DESCRIPTION_ID)
    public Room updatePopularity(@PathVariable String description, @RequestBody Double popularity) {
        return this.roomService.updatePopularity(description, popularity);
    }
}
