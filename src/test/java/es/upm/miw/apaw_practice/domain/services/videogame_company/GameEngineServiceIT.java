package es.upm.miw.apaw_practice.domain.services.videogame_company;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import es.upm.miw.apaw_practice.domain.models.videogame_company.GameEngine;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class GameEngineServiceIT {
    @Autowired
    private GameEngineService gameEngineService;

    @Test
    void testReadService(){
        GameEngine gameEngine = gameEngineService.read("MonoGame");
        assertNotNull(gameEngine);
        assertEquals("MonoGame", gameEngine.getName());
        assertEquals("C#", gameEngine.getProgrammingLanguage());
        assertEquals("Free", gameEngine.getLicense());

    }


}
