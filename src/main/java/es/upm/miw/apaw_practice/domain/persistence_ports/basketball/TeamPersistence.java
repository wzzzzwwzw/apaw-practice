package es.upm.miw.apaw_practice.domain.persistence_ports.basketball;
import es.upm.miw.apaw_practice.domain.models.basketball.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamPersistence {
    Team readByAlias(String alias);
    Team update(Team team);
    List<Team> findAll();

}
