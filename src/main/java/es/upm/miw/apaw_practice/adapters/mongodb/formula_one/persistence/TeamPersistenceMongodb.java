package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.TeamRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.formula_one.TeamPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("teamPersistence")
public class TeamPersistenceMongodb implements TeamPersistence {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamPersistenceMongodb(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void delete(String teamName) {
        this.teamRepository.deleteByTeamName(teamName);
    }
}
