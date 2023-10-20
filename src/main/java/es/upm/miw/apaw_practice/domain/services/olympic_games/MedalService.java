package es.upm.miw.apaw_practice.domain.services.olympic_games;

import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Medal;
import es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games.MedalPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games.OlympicGamesPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedalService {

    private final MedalPersistence medalPersistence;
    private final OlympicGamesPersistence olympicGamesPersistence;

    @Autowired
    public MedalService(MedalPersistence medalPersistence, OlympicGamesPersistence olympicGamesPersistence) {
        this.medalPersistence = medalPersistence;
        this.olympicGamesPersistence = olympicGamesPersistence;
    }

    public Medal readByMedalId(String medalID) {
        return this.medalPersistence.readByMedalId(medalID);
    }

    public Medal updateWinner(String medalID, Competitor winner) {
        Medal medal = this.medalPersistence.readByMedalId(medalID);
        medal.setWinner(winner);
        return this.medalPersistence.update(medal);
    }

    public List<String> findMedalTiersBySummerGamesAndAge(Boolean summerGames) {
        List<String> competitorsNames = this.olympicGamesPersistence.findCompetitorsOlderThanEighteenBySummerGames(summerGames);
        return this.medalPersistence.findTiersByCompetitor(competitorsNames);
    }
}
