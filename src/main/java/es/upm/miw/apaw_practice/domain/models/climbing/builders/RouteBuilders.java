package es.upm.miw.apaw_practice.domain.models.climbing.builders;

import es.upm.miw.apaw_practice.domain.models.climbing.Route;

public interface RouteBuilders {
    interface Name {
        Difficulty name(String name);
    }

    interface Difficulty {
        Optionals difficulty(String difficulty);
    }

    interface Optionals {
        Optionals key(String key);

        Route build();
    }
}
