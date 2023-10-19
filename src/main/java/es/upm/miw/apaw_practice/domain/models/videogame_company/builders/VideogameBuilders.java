package es.upm.miw.apaw_practice.domain.models.videogame_company.builders;

import es.upm.miw.apaw_practice.domain.models.videogame_company.Feature;
import es.upm.miw.apaw_practice.domain.models.videogame_company.GameEngine;
import es.upm.miw.apaw_practice.domain.models.videogame_company.Videogame;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface VideogameBuilders {

    interface Name{
        Price name(String name);
    }

    interface Price{
        ReleaseDate price(BigDecimal price);
    }

    interface ReleaseDate{
        Engine releaseDate(LocalDate releaseDate);
    }

    interface Engine{
        Features engine(GameEngine engine);
    }

    interface Features{
        Build features(List<Feature> features);
    }

    interface Build{
        Videogame build();
    }
}
