package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos.OlympicGamesRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.OlympicGamesEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.olympic_games.OlympicGames;
import es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games.OlympicGamesPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("olympicGamesPersistence")
public class OlympicGamesPersistenceMongodb implements OlympicGamesPersistence {
    private final OlympicGamesRepository olympicGamesRepository;

    @Autowired
    public OlympicGamesPersistenceMongodb(OlympicGamesRepository olympicGamesRepository) {
        this.olympicGamesRepository = olympicGamesRepository;
    }

    @Override
    public OlympicGames readByEdition(Integer edition) {
        return this.olympicGamesRepository
                .findByEdition(edition)
                .orElseThrow(() -> new NotFoundException("Olympic edition: " + edition))
                .toOlympicGames();
    }

    @Override
    public OlympicGames updateHostingPlace(Integer edition, String hostingPlace) {
        OlympicGamesEntity olympicGamesEntity = this.olympicGamesRepository
                .findByEdition(edition)
                .orElseThrow(() -> new NotFoundException("Olympic edition: " + edition));
        olympicGamesEntity.setHostingPlace(hostingPlace);
        return this.olympicGamesRepository.save(olympicGamesEntity).toOlympicGames();
    }

    @Override
    public List<OlympicGames> findOlympicGamesPlaceStreamByCompetition(List<String> competitorNames) {
        return this.olympicGamesRepository.findAll()
                .stream()
                .map(OlympicGamesEntity::toOlympicGames)
                .filter(olympicGames -> olympicGames
                        .getDisciplines()
                        .stream()
                        .anyMatch(discipline -> discipline
                                .getCompetitors()
                                .stream()
                                .anyMatch(competitor ->
                                        competitorNames.contains(competitor.getName())
                                )
                        )
                )
                .collect(Collectors.toList());
    }

}
