package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.domain.models.music.Song;
import es.upm.miw.apaw_practice.domain.services.music.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(AlbumResource.ALBUMS)
public class AlbumResource {

    static final String ALBUMS = "/music/albums";

    static final String DENOMINATION_ID = "/{denomination}";

    static final String SONGS = "/songs";

    private final AlbumService albumService;

    @Autowired
    public AlbumResource(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping(DENOMINATION_ID + SONGS)
    public Stream<Song> readSongsByAlbumDenomination(@PathVariable String denomination) {
        return this.albumService.readSongsByAlbumDenomination(denomination);
    }

    @DeleteMapping(DENOMINATION_ID)
    public void delete(@PathVariable String denomination) {
        this.albumService.delete(denomination);
    }
}
