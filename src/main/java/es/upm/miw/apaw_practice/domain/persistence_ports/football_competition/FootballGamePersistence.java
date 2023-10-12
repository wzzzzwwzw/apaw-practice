package es.upm.miw.apaw_practice.domain.persistence_ports.football_competition;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballGame;

import java.time.LocalDateTime;
import java.util.List;

public interface FootballGamePersistence {
    FootballGame read(String id);
    FootballGame updateDate(String id, LocalDateTime date);
    List<String> getGamesIdentifiers();
}
