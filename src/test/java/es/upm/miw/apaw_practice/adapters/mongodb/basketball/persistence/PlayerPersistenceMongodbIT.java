package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.basketball.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class PlayerPersistenceMongodbIT {

    @Autowired
    private PlayerPersistenceMongodb playerPersistenceMongodb;

    @Test
    void testReadByEmail() {
        Player player = this.playerPersistenceMongodb.readByEmail("email1@gmail.com");
        assertEquals("email1@gmail.com", player.getEmail());
        assertEquals("alero", player.getPosition());
        assertEquals(19, player.getAge());
    }

    @Test
    void testReadByEmailNotFound() {
        assertThrows(Exception.class, () -> {
            this.playerPersistenceMongodb.readByEmail("nonexistent@gmail.com");
        });
    }
}
