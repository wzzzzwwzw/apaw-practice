package es.upm.miw.apaw_practice.domain.models.videogame_company.builders;

import es.upm.miw.apaw_practice.domain.models.videogame_company.GameEngine;

public interface GameEngineBuilders {
    interface Name{
        ProgrammingLanguage name(String name);
    }

    interface ProgrammingLanguage{
        License programmingLanguage(String programmingLanguage);
    }

    interface License{
        Build license(String license);
    }

    interface Build{
        GameEngine build();
    }
}
