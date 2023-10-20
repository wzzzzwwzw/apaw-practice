package es.upm.miw.apaw_practice.domain.models.music.builders;

import es.upm.miw.apaw_practice.domain.models.music.Artist;
import es.upm.miw.apaw_practice.domain.models.music.MusicGenre;
import es.upm.miw.apaw_practice.domain.models.music.Song;

import java.util.List;

public interface SongBuilders {

    interface Title {
        Optionals title(String title);
    }

    interface Optionals {

        Optionals duration(Integer duration);

        Optionals remix(Boolean remix);

        Optionals rating(Double rating);

        Optionals musicGenre(MusicGenre musicGenre);

        Optionals artistsList(List<Artist> artistsList);

        Song build();
    }
}
