package es.upm.miw.apaw_practice.domain.models.airport.builders;

import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;

import java.time.LocalDate;

public interface AircraftBuilders {

    interface DateOfLastRevision{
        Capacity dateOfLastRevision(LocalDate dateOfLastRevision);
    }
    interface Capacity{
        Model capacity(Integer capacity);
    }
    interface Model{
        NumberPlate model(String model);
    }
    interface NumberPlate{
        Build numberPlate(String numberPlate);
    }
    interface Build{
        Aircraft build();
    }
}
