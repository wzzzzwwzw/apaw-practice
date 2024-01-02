package es.upm.miw.apaw_practice.domain.persistence_ports.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Room;

public interface RoomPersistence {
    Room findByDescription(String description);

    Room update(Room room);
}
