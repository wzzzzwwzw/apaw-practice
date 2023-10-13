package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.adapters.mongodb.music.MusicSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.music.Artist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;

@RestTestConfig
class ArtistResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private MusicSeederService musicSeederService;

    @AfterEach
    void resetDB() {
        this.musicSeederService.deleteAll();
        this.musicSeederService.seedDatabase();
    }

    @Test
    void testUpdateArtistPhoneNumber() {
        this.webTestClient
                .put()
                .uri(ArtistResource.ARTISTS + ArtistResource.DNI_ID + ArtistResource.PHONE_NUMBER, "22222222D")
                .body(BodyInserters.fromValue(666666666))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Artist.class)
                .value(Assertions::assertNotNull)
                .value(artist -> {
                    Assertions.assertEquals("22222222D", artist.getDni());
                    Assertions.assertEquals("Ozuna", artist.getFullName());
                    Assertions.assertEquals(666666666, artist.getPhoneNumber());
                    Assertions.assertEquals(LocalDate.of(1989, 12, 30), artist.getBirthDate());
                });
    }

    @Test
    void testUpdateArtistPhoneNumberArtistNotFound() {
        this.webTestClient
                .put()
                .uri(ArtistResource.ARTISTS + ArtistResource.DNI_ID + ArtistResource.PHONE_NUMBER, "11111111A")
                .body(BodyInserters.fromValue(555555555))
                .exchange()
                .expectStatus().isNotFound();
    }


}
