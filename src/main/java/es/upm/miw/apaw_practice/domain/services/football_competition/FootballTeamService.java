package es.upm.miw.apaw_practice.domain.services.football_competition;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballTeam;
import es.upm.miw.apaw_practice.domain.persistence_ports.football_competition.FootballTeamPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootballTeamService {
    private final FootballTeamPersistence footballTeamPersistence;

    @Autowired
    public FootballTeamService(FootballTeamPersistence footballTeamPersistence) {
        this.footballTeamPersistence = footballTeamPersistence;
    }

    public FootballTeam read(String city) {
        return this.footballTeamPersistence.read(city);
    }
}
