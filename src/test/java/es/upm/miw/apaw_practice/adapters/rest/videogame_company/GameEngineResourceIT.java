package es.upm.miw.apaw_practice.adapters.rest.videogame_company;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.videogame_company.GameEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RestTestConfig
public class GameEngineResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testGetGameEngineByName(){
        this.webTestClient
                .get()
                .uri(GameEngineResource.GAME_ENGINES+GameEngineResource.NAME_ID,"MonoGame")
                .exchange()
                .expectStatus().isOk()
                .expectBody(GameEngine.class)
                .value(Assertions::assertNotNull)
                .value(
                        gameEngine -> {
                            assertEquals("MonoGame", gameEngine.getName());
                            assertEquals("C#", gameEngine.getProgrammingLanguage());
                            assertEquals("Free", gameEngine.getLicense());
                        }
                );
    }

    @Test
    void testGetGameEngineNamesByCompanyCountryAndGameGenre(){
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                    uriBuilder.path(GameEngineResource.GAME_ENGINES + GameEngineResource.SEARCH)
                            .queryParam("q","country:Japan"+";genre:Action")
                            .build()
                )
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(names -> assertFalse(names.isEmpty()))
                .value(names -> assertTrue(names.get(0).contains("Unity")))
                .value(names -> assertTrue(names.get(0).contains("Unreal Engine")));

    }
}
