package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company.GameEnginePersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class GameEnginePersistenceMongodbIT {
    @Autowired
    private GameEnginePersistence gameEnginePersistence;

    @Test
    void testGameEngineNotFound(){
        assertThrows(NotFoundException.class,()->this.gameEnginePersistence.read("x"));
    }

    @Test
    void testGameEngineFound(){
        assertNotNull(this.gameEnginePersistence.read("MonoGame"));
    }

}
