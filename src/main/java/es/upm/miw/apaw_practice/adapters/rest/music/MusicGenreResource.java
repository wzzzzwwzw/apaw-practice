package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.domain.models.music.MusicGenre;
import es.upm.miw.apaw_practice.domain.services.music.MusicGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(MusicGenreResource.MUSIC_GENRES)
public class MusicGenreResource {

    static final String MUSIC_GENRES = "/music/music-genres";

    static final String TYPE_ID = "/{type}";


    private final MusicGenreService musicGenreService;

    @Autowired
    public MusicGenreResource(MusicGenreService musicGenreService) {
        this.musicGenreService = musicGenreService;
    }

    @PostMapping
    public MusicGenre create(@RequestBody MusicGenre musicGenre) {
        return this.musicGenreService.create(musicGenre);
    }

    @PatchMapping(TYPE_ID)
    public MusicGenre updateMusicGenrePopularity(@PathVariable String type) {
        return this.musicGenreService.updatePopularityByType(type);
    }
}
