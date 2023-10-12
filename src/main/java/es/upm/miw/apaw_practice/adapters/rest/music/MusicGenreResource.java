package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.domain.models.music.MusicGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import es.upm.miw.apaw_practice.domain.services.music.MusicGenreService;

@RestController
@RequestMapping(MusicGenreResource.MUSIC_GENRES)
public class MusicGenreResource {

    static final String MUSIC_GENRES = "/music/music-genres";

    private final MusicGenreService musicGenreService;

    @Autowired
    public MusicGenreResource(MusicGenreService musicGenreService) {
        this.musicGenreService = musicGenreService;
    }

    @PostMapping
    public MusicGenre create(@RequestBody MusicGenre musicGenre) {
        return this.musicGenreService.create(musicGenre);
    }
}
