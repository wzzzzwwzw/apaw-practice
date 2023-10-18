package es.upm.miw.apaw_practice.domain.services.olympic_games;

import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Medal;
import es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games.MedalPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedalService {

    private final MedalPersistence medalPersistence;

    @Autowired
    public MedalService(MedalPersistence medalPersistence) {
        this.medalPersistence = medalPersistence;
    }

    public Medal readByMedalId(String medalID) {
        return this.medalPersistence.readByMedalId(medalID);
    }

    public Medal updateWinner(String medalID, Competitor winner) {
        Medal medal = this.medalPersistence.readByMedalId(medalID);
        medal.setWinner(winner);
        return this.medalPersistence.update(medal);
    }
}
