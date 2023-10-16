package es.upm.miw.apaw_practice.domain.services.olympic_games;

import es.upm.miw.apaw_practice.domain.models.olympic_games.OlympicGames;
import es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games.OlympicGamesPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OlympicGamesService {

    private final OlympicGamesPersistence olympicGamesPersistence;

    @Autowired
    public OlympicGamesService(OlympicGamesPersistence olympicGamesPersistence) {
        this.olympicGamesPersistence = olympicGamesPersistence;
    }

    public OlympicGames readByEdition(Integer edition) {
        return this.olympicGamesPersistence.readByEdition(edition);
    }
}
