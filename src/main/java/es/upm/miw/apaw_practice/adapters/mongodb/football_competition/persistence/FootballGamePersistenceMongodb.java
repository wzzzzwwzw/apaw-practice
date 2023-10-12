package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos.FootballGameRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballGameEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballGame;
import es.upm.miw.apaw_practice.domain.persistence_ports.football_competition.FootballGamePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository("footballGamePersistence")
public class FootballGamePersistenceMongodb implements FootballGamePersistence {
    private final FootballGameRepository footballGameRepository;

    @Autowired
    public FootballGamePersistenceMongodb(FootballGameRepository footballGameRepository) {
        this.footballGameRepository = footballGameRepository;
    }

    @Override
    public FootballGame read(String id) {
        return this.footballGameRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Game Id: " + id))
                .toFootballGame();
    }

    @Override
    public FootballGame updateDate(String id, LocalDateTime date) {
        FootballGameEntity game = this.footballGameRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Game Id: " + id));
        game.setDate(date);
        return this.footballGameRepository.save(game).toFootballGame();
    }

    @Override
    public List<String> getGamesIdentifiers() {
        return this.footballGameRepository
                .findAll().stream()
                .map(FootballGameEntity::getId)
                .toList();
    }
}
