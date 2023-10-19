package es.upm.miw.apaw_practice.domain.services.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Team;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.TeamPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamBasketballService {

    private final TeamPersistence teamBasketballPersistence;
    @Autowired
    public TeamBasketballService(TeamPersistence teamPersistence){
        this.teamBasketballPersistence=teamPersistence;
    }

    public Team read(String alias){
        return this.teamBasketballPersistence.readByAlias(alias);
    }

}
