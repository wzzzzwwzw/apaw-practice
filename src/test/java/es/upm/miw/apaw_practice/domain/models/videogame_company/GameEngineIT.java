package es.upm.miw.apaw_practice.domain.models.videogame_company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class GameEngineIT {

    @Test
    void testGameEngineBuilder(){
        GameEngine gameEngine = GameEngine.build()
                .name("Atlus Engine")
                .programmingLanguage("C C++")
                .license("Paid")
                .build();
        assertNotNull(gameEngine);
        assertEquals("Atlus Engine", gameEngine.getName());
        assertEquals("C C++", gameEngine.getProgrammingLanguage());
        assertEquals("Paid", gameEngine.getLicense());
    }
}
