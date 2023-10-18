package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.adapters.mongodb.music.MusicSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.adapters.rest.music.dtos.DenominationCollectionDTO;
import es.upm.miw.apaw_practice.domain.models.music.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testGetPhoneNumberByTypeAndRecordLabel() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(AlbumResource.ALBUMS + AlbumResource.SEARCH)
                        .queryParam("q", "type:reggaeton;recordLabel:La Industria Inc")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Integer.class)
                .hasSize(3);
    }

    @Test
    void testGetDifferentDenominationsByFullname() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(AlbumResource.ALBUMS + AlbumResource.SEARCH2)
                        .queryParam("q", "fullname:J Balvin")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(DenominationCollectionDTO.class)
                .value(denominationCollectionDTO -> {
                    assertEquals(2, denominationCollectionDTO.getDenominations().size());
                    assertTrue(denominationCollectionDTO.getDenominations().contains("Colores"));
                    assertTrue(denominationCollectionDTO.getDenominations().contains("Fearless"));
                });
    }
}
