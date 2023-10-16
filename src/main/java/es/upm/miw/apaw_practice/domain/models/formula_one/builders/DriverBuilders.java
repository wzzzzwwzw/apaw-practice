package es.upm.miw.apaw_practice.domain.models.formula_one.builders;

import es.upm.miw.apaw_practice.domain.models.formula_one.Driver;

public interface DriverBuilders {

    interface Number {
        DriverName number(Integer number);
    }

    interface DriverName {
        Nationality driverName(String driverName);
    }

    interface Nationality {
        Optionals nationality(String nationality);
    }

    interface Optionals {
        Optionals points(Float points);

        Driver build();
    }
}
