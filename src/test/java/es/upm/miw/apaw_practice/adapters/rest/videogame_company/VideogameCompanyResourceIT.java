package es.upm.miw.apaw_practice.adapters.rest.videogame_company;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.videogame_company.VideogameCompany;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class VideogameCompanyResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testPostVideoGameCompany(){
        VideogameCompany newVideoGameCompany = new VideogameCompany(
                "Electronic Arts", "US", LocalDate.of(1982,5,27));
        this.webTestClient
                .post()
                .uri(VideogameCompanyResource.VIDEOGAME_COMPANIES)
                .body(BodyInserters.fromValue(newVideoGameCompany))
                .exchange()
                .expectStatus().isOk()
                .expectBody(VideogameCompany.class)
                .value(Assertions::assertNotNull)
                .value(
                        videogameCompany -> {
                            assertEquals(newVideoGameCompany.getName(),videogameCompany.getName());
                            assertEquals(newVideoGameCompany.getCountry(), videogameCompany.getCountry());
                            assertEquals(newVideoGameCompany.getRegistrationDate(), videogameCompany.getRegistrationDate());
                        }
                );
    }

    @Test
    void testPostVideogameCompanyExist(){
        VideogameCompany newVideoGameCompany = new VideogameCompany(
                "Konami", "US", LocalDate.of(1982,5,27));
        this.webTestClient
                .post()
                .uri(VideogameCompanyResource.VIDEOGAME_COMPANIES)
                .body(BodyInserters.fromValue(newVideoGameCompany))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

}
