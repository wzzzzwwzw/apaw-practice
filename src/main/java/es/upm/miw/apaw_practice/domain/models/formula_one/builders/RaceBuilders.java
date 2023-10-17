package es.upm.miw.apaw_practice.domain.models.formula_one.builders;

import es.upm.miw.apaw_practice.domain.models.formula_one.Driver;
import es.upm.miw.apaw_practice.domain.models.formula_one.Race;

import java.time.LocalDate;
import java.util.List;

public interface RaceBuilders {

    interface CircuitName {
        HostCountry circuitName(String circuitName);
    }

    interface HostCountry {
        Optionals hostCountry(String hostCountry);
    }

    interface Optionals {
        Optionals date(LocalDate date);

        Optionals raceDrivers(List<Driver> raceDrivers);

        Optionals laps(Integer laps);

        Optionals nightRace(Boolean nightRace);

        Race build();
    }
}
