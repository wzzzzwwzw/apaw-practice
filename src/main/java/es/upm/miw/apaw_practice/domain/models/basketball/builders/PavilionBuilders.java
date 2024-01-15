package es.upm.miw.apaw_practice.domain.models.basketball.builders;

import es.upm.miw.apaw_practice.domain.models.basketball.Pavilion;

public interface PavilionBuilders {


    interface Pavname {
        Direction pavname(String pavname);
    }

    interface Direction {
        Capacity direction(String direction);
    }

    interface Capacity {
        Pavilion build();

        Capacity capacity(int i);
    }
}