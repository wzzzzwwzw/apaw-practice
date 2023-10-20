package es.upm.miw.apaw_practice.domain.models.aquarium.builders;

import es.upm.miw.apaw_practice.domain.models.aquarium.Fish;

import java.time.LocalDate;

public interface FishBuilders {
    public interface Species {
        Color species(String species);
    }

    public interface Color {
        DateOfEntrance color(String color);
    }

    public interface DateOfEntrance {
        Build dateOfEntrance(LocalDate dateOfEntrance);
    }

    public interface Build {
        Fish build();
    }
}
