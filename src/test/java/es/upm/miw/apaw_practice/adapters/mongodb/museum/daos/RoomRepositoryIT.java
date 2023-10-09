package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.RoomEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class RoomRepositoryIT {

    @Autowired
    private RoomRepository roomRepository;

    @Test
    void testCreateAndRead() {
        Assertions.assertTrue(this.roomRepository.findAll().stream()
                .anyMatch(room ->
                        "Sala 012".equals(room.getDescription())
                        && 1 == room.getFloor()
                        && 9.75 == room.getPopularity()
                ));
    }
}
