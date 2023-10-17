package es.upm.miw.apaw_practice.adapters.rest.aquarium;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.aquarium.AquariumCurator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@RestTestConfig
public class AquariumCuratorResourceIT {
    @Autowired
    private WebTestClient webTestClient;
    @Test
    void testUpdate(){
        String name = "Atlantis";
        String position = "Madrid";
        this.webTestClient
                .put()
                .uri(AquariumCuratorResource.AquariumCurator + AquariumCuratorResource.NAME+AquariumCuratorResource.POSITION,"Atlantis")
                .body(BodyInserters.fromValue(position))
                .exchange()
                .expectStatus().isOk()
                .expectBody(AquariumCurator.class)
                .value(aquariumCurator -> {
                    assertNotNull(aquariumCurator);
                   assertEquals(name,aquariumCurator.getName());
                   assertEquals(position,aquariumCurator.getPosition());
                });
    }
    @Test
    void testUpdateNotExist(){
        String name = "Atlantis";
        String position = "Madrid";
        this.webTestClient
                .put()
                .uri(AquariumCuratorResource.AquariumCurator + AquariumCuratorResource.NAME + AquariumCuratorResource.POSITION,"Madrid")
                .body(BodyInserters.fromValue(position))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }
}
