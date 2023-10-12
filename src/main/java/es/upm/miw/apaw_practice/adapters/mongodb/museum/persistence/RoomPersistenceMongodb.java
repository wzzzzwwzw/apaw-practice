package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.RoomRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.RoomEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.museum.Room;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.RoomPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("roomPersistence")
public class RoomPersistenceMongodb implements RoomPersistence {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomPersistenceMongodb(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room findByDescription(String description) {
        return this.roomRepository.findAll().stream()
                .filter(room -> description.equals(room.getDescription()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Room with description: " + description))
                .toRoom();
    }

    @Override
    public Room update(String description, Room room) {
        RoomEntity roomDB = this.roomRepository.findById(description)
                .orElseThrow(() -> new NotFoundException("Room with description: " + description));
        roomDB.setFloor(room.getFloor());
        roomDB.setPopularity(room.getPopularity());
        return this.roomRepository.save(roomDB).toRoom();
    }
}
