package es.upm.miw.apaw_practice.adapters.rest.coffee_shop;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Dining;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.BodyInserters;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class DiningResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testPostWire() {
        Dining diningCreated = new Dining("5", "location5", 6);
        this.webTestClient
                .post()
                .uri(DiningResource.DINING)
                .body(BodyInserters.fromValue(diningCreated))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Dining.class)
                .value(Assertions::assertNotNull)
                .value(dining -> {
                    assertEquals(diningCreated.getDiningNumber(), dining.getDiningNumber());
                    assertEquals(diningCreated.getLocation(), dining.getLocation());
                    assertEquals(diningCreated.getCapacity(), dining.getCapacity());
                });
    }
}
