package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Room;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.RoomPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomPersistence roomPersistence;

    @Autowired
    public RoomService(RoomPersistence roomPersistence) {
        this.roomPersistence = roomPersistence;
    }

    public Room updatePopularity(String description, Double popularity) {
        // TODO
        return null;
    }
}
