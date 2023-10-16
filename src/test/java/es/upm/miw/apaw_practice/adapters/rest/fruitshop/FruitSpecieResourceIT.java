package es.upm.miw.apaw_practice.adapters.rest.fruitshop;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitSpecie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class FruitSpecieResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreatFruitSpecie(){
        FruitSpecie fruitSpecieNoExist = new FruitSpecie("Simple","Spring",100);
        this.webTestClient
                .post()
                .uri(FruitSpecieResource.FRUITSPECIR)
                .body(BodyInserters.fromValue(fruitSpecieNoExist))
                .exchange()
                .expectStatus().isOk()
                .expectBody(FruitSpecie.class)
                .value(Assertions::assertNotNull)
                .value(fruitSpecie -> {
                    assertEquals(fruitSpecieNoExist.getSpecie(), fruitSpecie.getSpecie());
                    assertEquals(fruitSpecieNoExist.getSeason(), fruitSpecie.getSeason());
                    assertEquals(fruitSpecieNoExist.getSize(),fruitSpecie.getSize());
                        });
    }

    @Test
    void testPostAlreadyExistSpecie() {
        FruitSpecie fruitSpecie = new FruitSpecie("Tropical","Spring",8);
        this.webTestClient
                .post()
                .uri(FruitSpecieResource.FRUITSPECIR)
                .body(BodyInserters.fromValue(fruitSpecie))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
