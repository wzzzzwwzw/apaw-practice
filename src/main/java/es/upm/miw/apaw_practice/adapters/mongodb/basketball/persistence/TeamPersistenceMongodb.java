package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.TeamBasketballRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.basketball.Team;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.TeamPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("teamPersistenceBasketball")
public class TeamPersistenceMongodb implements TeamPersistence {
    private final TeamBasketballRepository teamBasketballRepository;

    @Autowired
    public TeamPersistenceMongodb(TeamBasketballRepository teamBasketballRepository) {
        this.teamBasketballRepository = teamBasketballRepository;
    }

    @Override
    public Team readByAlias(String alias) {
        return this.teamBasketballRepository.findByAlias(alias)
                .orElseThrow(() -> new NotFoundException("Team alias: " + alias))
                .toTeam();
    }

}
