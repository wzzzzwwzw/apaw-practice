package es.upm.miw.apaw_practice.domain.services.formula_one;

import es.upm.miw.apaw_practice.domain.persistence_ports.formula_one.TeamPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamPersistence teamPersistence;

    @Autowired
    public TeamService(TeamPersistence teamPersistence) {
        this.teamPersistence = teamPersistence;
    }

    public void delete(String teamName) {
        this.teamPersistence.delete(teamName);
    }
}
