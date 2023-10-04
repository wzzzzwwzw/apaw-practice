package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities.GameEngineEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class GameEngineRepositoryIT{
    @Autowired
    private GameEngineRepository gameEngineRepository;

    private static final String CUSTOMIZED_GAME_ENGINE = "Unity";

    @Test
    void testGameEngineFindByName(){
        assertTrue(gameEngineRepository.findByName(CUSTOMIZED_GAME_ENGINE).isPresent());
        GameEngineEntity gameEngine = gameEngineRepository.findByName(CUSTOMIZED_GAME_ENGINE).get();
        assertEquals("C#", gameEngine.getProgrammingLanguage());
        assertEquals("Freemium", gameEngine.getLicense());
    }
}
