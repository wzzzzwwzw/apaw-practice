package es.upm.miw.apaw_practice.adapters.rest.aquarium;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
@RestTestConfig
public class FishpondResourceIT {
    @Autowired
    private WebTestClient webTestClient;
    @Test
    void testDelete(){
        this.webTestClient
                .delete()
                .uri(FishpondResource.FISHPONDS +FishpondResource.DIRECTION,"First floor")
                .exchange()
                .expectStatus().isOk();
    }
}
