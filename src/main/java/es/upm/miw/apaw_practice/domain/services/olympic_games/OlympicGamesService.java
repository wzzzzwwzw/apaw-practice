package es.upm.miw.apaw_practice.domain.services.olympic_games;

import es.upm.miw.apaw_practice.domain.models.olympic_games.OlympicGames;
import es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games.MedalPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games.OlympicGamesPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OlympicGamesService {

    private final OlympicGamesPersistence olympicGamesPersistence;
    private final MedalPersistence medalPersistence;

    @Autowired
    public OlympicGamesService(OlympicGamesPersistence olympicGamesPersistence, MedalPersistence medalPersistence) {
        this.olympicGamesPersistence = olympicGamesPersistence;
        this.medalPersistence = medalPersistence;
    }

    public OlympicGames updateHostingPlace(Integer edition, String hostingPlace) {
        return this.olympicGamesPersistence.updateHostingPlace(edition, hostingPlace);
    }

    public OlympicGames readByEdition(Integer edition) {
        return this.olympicGamesPersistence.readByEdition(edition);
    }

    public List<String> findHostingPlaceByCompetition(String competition) {
        List<String> competitorNames = medalPersistence.findCompetitorsByCompetition(competition);
        return this.olympicGamesPersistence
                .findOlympicGamesPlaceStreamByCompetition(competitorNames)
                .stream()
                .map(OlympicGames::getHostingPlace)
                .toList();
    }
}
