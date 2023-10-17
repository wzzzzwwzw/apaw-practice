package es.upm.miw.apaw_practice.domain.models.football_competition;

import java.math.BigDecimal;

public interface FootballPlayerBuilders {
    interface Name {
        Optionals name(String name);
    }

    interface Optionals {
        Optionals salary(BigDecimal salary);

        Optionals height(float height);

        Optionals goals(Integer goals);

        Optionals assists(Integer assists);

        Optionals team(FootballTeam team);

        FootballPlayer build();
    }
}
