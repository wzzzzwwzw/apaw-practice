package es.upm.miw.apaw_practice.domain.models.subway.builders;

import es.upm.miw.apaw_practice.domain.models.subway.Line;
import es.upm.miw.apaw_practice.domain.models.subway.Schedule;
import es.upm.miw.apaw_practice.domain.models.subway.Station;

import java.util.List;

public interface LineBuilders {
    interface Label {
        Optionals label(String label);
    }

    interface Optionals {
        Optionals color(String color);

        Optionals works(Boolean works);

        Optionals stations(List<Station> station);

        Optionals schedule(Schedule schedule);

        Line build();
    }
}
