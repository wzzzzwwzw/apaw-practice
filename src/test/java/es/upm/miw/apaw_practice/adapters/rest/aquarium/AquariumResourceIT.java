package es.upm.miw.apaw_practice.adapters.rest.aquarium;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserters;
@RestTestConfig
class AquariumResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testGetByDescription(){
        this.webTestClient
                .get()
                .uri(AquariumResource.AQUARIUMS+AquariumResource.DESCRIPTION,"Sea")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Aquarium.class)
                .value(Assertions::assertNotNull)
                .value(aquarium -> {
                    assertEquals("Sea",aquarium.getDescription());
                    assertEquals(2000.55,aquarium.getSize());
                    assertEquals(5000,aquarium.getMaximumFishCapacity());
                        });
    }
    @Test
    void testPostAquarium() {
        Aquarium aquariumNotExists = new Aquarium("notExistsDescription", 2000.55, 5000);
        this.webTestClient
                .post()
                .uri(AquariumResource.AQUARIUMS)
                .body(BodyInserters.fromValue(aquariumNotExists))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Aquarium.class)
                .value(Assertions::assertNotNull)
                .value(aquarium -> {
                    assertEquals(aquariumNotExists.getDescription(), aquarium.getDescription());
                    assertEquals(aquariumNotExists.getSize(), aquarium.getSize());
                    assertEquals(aquariumNotExists.getMaximumFishCapacity(), aquarium.getMaximumFishCapacity());
                });
    }

    @Test
    void testPostAlreadyExistAquariumDescription() {
        Aquarium aquariumNotExists = new Aquarium("Sea", 2000.55, 5000);
        this.webTestClient
                .post()
                .uri(AquariumResource.AQUARIUMS)
                .body(BodyInserters.fromValue(aquariumNotExists))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
