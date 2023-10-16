package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.adapters.mongodb.music.MusicSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.music.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
class AlbumResourceIT {

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
    void testReadSongsByAlbumDenomination() {
        this.webTestClient
                .get()
                .uri(AlbumResource.ALBUMS + AlbumResource.DENOMINATION_ID + AlbumResource.SONGS, "Colores")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Song.class)
                .hasSize(2);
    }

    @Test
    void testReadSongsByAlbumDenominationNotFound() {
        this.webTestClient
                .get()
                .uri(AlbumResource.ALBUMS + AlbumResource.DENOMINATION_ID + AlbumResource.SONGS, "album2")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testDeleteAlbum() {
        this.webTestClient
                .delete()
                .uri(AlbumResource.ALBUMS + AlbumResource.DENOMINATION_ID, "Fearless")
                .exchange()
                .expectStatus().isOk();
    }
}
