package es.upm.miw.apaw_practice.domain.models.music.builders;

import es.upm.miw.apaw_practice.domain.models.music.Artist;

import java.time.LocalDate;

public interface ArtistBuilders {

    interface Dni {
        Optionals dni(String dni);
    }

    interface Optionals {
        Optionals fullName(String fullName);

        Optionals phoneNumber(Integer phoneNumber);

        Optionals birthDate(LocalDate birthDate);

        Artist build();
    }
}
