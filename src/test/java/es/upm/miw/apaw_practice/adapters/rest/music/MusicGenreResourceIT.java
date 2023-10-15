package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.adapters.mongodb.music.MusicSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.music.MusicGenre;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class MusicGenreResourceIT {

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
    void testPostMusicGenre() {
        MusicGenre musicGenreNotExists = new MusicGenre("flamenco", "flamenco music", 10, "Spain");
        this.webTestClient
                .post()
                .uri(MusicGenreResource.MUSIC_GENRES)
                .body(BodyInserters.fromValue(musicGenreNotExists))
                .exchange()
                .expectStatus().isOk()
                .expectBody(MusicGenre.class)
                .value(Assertions::assertNotNull)
                .value(musicGenre -> {
                    assertEquals(musicGenreNotExists.getType(), musicGenre.getType());
                    assertEquals(musicGenreNotExists.getDescription(), musicGenre.getDescription());
                    assertEquals(musicGenreNotExists.getPopularity(), musicGenre.getPopularity());
                    assertEquals(musicGenreNotExists.getCountryOrigin(), musicGenre.getCountryOrigin());
                });
    }

    @Test
    void testPostAlreadyExistMusicGenreType() {
        MusicGenre musicGenreNotExists = new MusicGenre("reggaeton", "reggaeton music", 10, "Puerto Rico");
        this.webTestClient
                .post()
                .uri(MusicGenreResource.MUSIC_GENRES)
                .body(BodyInserters.fromValue(musicGenreNotExists))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    void testPatchMusicGenre() {
        this.webTestClient
                .patch()
                .uri(MusicGenreResource.MUSIC_GENRES + MusicGenreResource.TYPE_ID, "trap")
                .exchange()
                .expectStatus().isOk()
                .expectBody(MusicGenre.class)
                .value(Assertions::assertNotNull)
                .value(musicGenre -> {
                    assertEquals("trap", musicGenre.getType());
                    assertEquals("trap music", musicGenre.getDescription());
                    assertEquals(7, musicGenre.getPopularity());
                    assertEquals("United States", musicGenre.getCountryOrigin());
                });
    }
}
