package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos.FootballTeamRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballTeam;
import es.upm.miw.apaw_practice.domain.persistence_ports.football_competition.FootballTeamPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("footballTeamPersistence")
public class FootballTeamPersistenceMongodb implements FootballTeamPersistence {
    private final FootballTeamRepository footballTeamRepository;

    @Autowired
    public FootballTeamPersistenceMongodb(FootballTeamRepository footballTeamRepository) {
        this.footballTeamRepository = footballTeamRepository;
    }

    @Override
    public FootballTeam read(String city) {
        return this.footballTeamRepository
                .findByCity(city)
                .orElseThrow(() -> new NotFoundException("Football Team City: " + city))
                .toFootballTeam();
    }
}
