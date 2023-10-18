package es.upm.miw.apaw_practice.domain.models.film;

import java.time.LocalDate;

public interface DirectorBuilders {

    interface Dni {
        Name dni(String dni);
    }

    interface Name {
        Optionals name(String name);
    }

    interface Optionals {
        Optionals surname(String surname);

        Optionals dateOfBirth(LocalDate dateOfBirth);

        Director build();
    }
}
