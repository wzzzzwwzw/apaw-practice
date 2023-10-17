package es.upm.miw.apaw_practice.adapters.rest.fruitshop;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.FruitShopSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitShop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.IOException;
import java.util.List;


import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class FruitShopResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private FruitShopSeederService fruitShopSeederService;

    @BeforeEach
    void cleanUp(){
        this.fruitShopSeederService.deleteAll();
        this.fruitShopSeederService.seedDatabase();
    }

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(FruitShopResource.FRUITSHOP +FruitShopResource.ID_NAME, "Fruit Haven")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testPatchEndPoint(){
        this.webTestClient
                .patch()
                .uri(FruitShopResource.FRUITSHOP + FruitShopResource.ID_NAME, "Fruit Test")
                .exchange()
                .expectStatus().isOk()
                .expectBody(FruitShop.class)
                .value(Assertions::assertNotNull)
                .value(fruitShop -> {

                assertEquals("Fruit Test", fruitShop.getName());
                assertEquals("New Address", fruitShop.getAddress());

                });
    }

    @Test
    void testFindAddressByFruitSpecie(){
        List<String> expected = List.of("Malaga");
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path(FruitShopResource.FRUITSHOP + FruitShopResource.SEARCH).queryParam("q","specie:Normal").build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(responseBody -> {
                    assertNotNull(responseBody);
                    ObjectMapper objectMapper = new ObjectMapper();
                    try {
                        List<String> actual = objectMapper.readValue(responseBody, new TypeReference<List<String>>() {});
                        assertEquals(expected, actual);
                    } catch (IOException e) {
                        fail("Failed to parse the JSON response");
                    }
                });

    }

}
