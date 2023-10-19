package es.upm.miw.apaw_practice.domain.models.music.builders;

import es.upm.miw.apaw_practice.domain.models.music.MusicGenre;

public interface MusicGenreBuilders {

    interface Type {
        Optionals type(String type);
    }

    interface Optionals {
        Optionals description(String description);

        Optionals popularity(Integer popularity);

        Optionals countryOrigin(String countryOrigin);

        MusicGenre build();
    }
}
