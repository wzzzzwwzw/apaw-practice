package es.upm.miw.apaw_practice.adapters.rest.zoo;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.zoo.Animal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class AnimalResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdate() {
        int age = 999;
        String identificationChip = "005DOG";
        this.webTestClient
                .put()
                .uri(AnimalResource.ANIMALS + AnimalResource.ID_IDENTIFICATION_CHIP + AnimalResource.AGE, identificationChip)
                .body(BodyInserters.fromValue(age))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Animal.class)
                .value(animal -> {
                    assertNotNull(animal);
                    assertEquals(identificationChip, animal.getIdentificationChip());
                    assertEquals(age, animal.getAge());
                });
    }

    @Test
    void testFindByHabitat() {
        this.webTestClient
                .get()
                .uri(AnimalResource.ANIMALS + AnimalResource.IDENTIFICATIONCHIP + AnimalResource.SEARCH_BY_SPECIES_HABITAT + "?q=habitat:human houses")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(Assertions::assertNotNull)
                .value(identificationChip -> {
                    assertEquals("080CAT", identificationChip);
                });

    }

    @Test
    void testUpdateNotExits() {
        int age = 33;
        String identificationChip = "XXXX";
        this.webTestClient
                .put()
                .uri(AnimalResource.ANIMALS + AnimalResource.ID_IDENTIFICATION_CHIP + AnimalResource.AGE, identificationChip)
                .body(BodyInserters.fromValue(age))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }
}
