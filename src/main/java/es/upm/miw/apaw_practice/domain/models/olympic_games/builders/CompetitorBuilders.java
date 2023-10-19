package es.upm.miw.apaw_practice.domain.models.olympic_games.builders;

import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;

public interface CompetitorBuilders {

    interface Name {
        Optionals name(String name);
    }

    interface Optionals {
        Optionals nationality(String nationality);

        Optionals age(Integer age);

        Competitor build();
    }
}
