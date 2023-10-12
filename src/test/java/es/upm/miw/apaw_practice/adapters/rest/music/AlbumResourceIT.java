package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.music.Song;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
class AlbumResourceIT {

    @Autowired
    private WebTestClient webTestClient;

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

}
