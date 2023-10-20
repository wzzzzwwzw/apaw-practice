package es.upm.miw.apaw_practice.domain.persistence_ports.climbing;

import es.upm.miw.apaw_practice.domain.models.climbing.Climber;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClimberPersistence {
    Climber readByEmail(String email);

    void delete(String email);

    List<Climber> findByLevel(String level);
}
