package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos.FootballPlayerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballPlayerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballPlayer;
import es.upm.miw.apaw_practice.domain.persistence_ports.football_competition.FootballPlayerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("footballPlayerPersistence")
public class FootballPlayerPersistenceMongodb implements FootballPlayerPersistence {

    private final FootballPlayerRepository footballPlayerRepository;

    @Autowired
    public FootballPlayerPersistenceMongodb(FootballPlayerRepository footballPlayerRepository) {
        this.footballPlayerRepository = footballPlayerRepository;
    }

    @Override
    public FootballPlayer readByName(String name) {
        return this.footballPlayerRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Player name: " + name))
                .toFootballPlayer();
    }

    @Override
    public FootballPlayer updateGoals(String name, Integer goals) {
        FootballPlayerEntity player = this.footballPlayerRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Player Name: " + name));
        player.setGoals(goals);
        return this.footballPlayerRepository.save(player).toFootballPlayer();
    }
}
