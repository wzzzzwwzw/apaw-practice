package es.upm.miw.apaw_practice.domain.services.football_competition;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballPlayer;
import es.upm.miw.apaw_practice.domain.persistence_ports.football_competition.FootballPlayerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootballPlayerService {
    private final FootballPlayerPersistence footballPlayerPersistence;

    @Autowired
    public FootballPlayerService(FootballPlayerPersistence footballPlayerPersistence) {
        this.footballPlayerPersistence = footballPlayerPersistence;
    }

    public FootballPlayer updateGoals(String name, Integer goals) {
        return this.footballPlayerPersistence.updateGoals(name, goals);
    }
}
