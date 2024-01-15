package es.upm.miw.apaw_practice.domain.models.subway.builders;

import es.upm.miw.apaw_practice.domain.models.subway.Station;

public interface StationBuilders {
    interface Name {
        Optionals name(String name);
    }

    interface Optionals {

        Optionals order(String order);

        Optionals open(Boolean open);

        Station build();
    }
}
