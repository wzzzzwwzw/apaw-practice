package es.upm.miw.apaw_practice.domain.models.airport.builders;


import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;

import java.time.LocalDate;
import java.util.List;

public interface AirLineBuilders {
    interface Name{
         DayOfFoundation name(String name);
    }
    interface DayOfFoundation{
        Aircrafts dayOfFoundation(LocalDate dayOfFoundations);
    }
    interface Aircrafts{
        Build aricrafts(List<Aircraft> aircrafts);
    }
    interface Build{
        AirLine build();
    }
}
