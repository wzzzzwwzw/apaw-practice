package es.upm.miw.apaw_practice.adapters.rest.fruitshop;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitShop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class FruitShopResourceIT {
    @Autowired
    private WebTestClient webTestClient;

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

}
