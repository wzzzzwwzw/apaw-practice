package es.upm.miw.apaw_practice.domain.persistence_ports.climbing;

import es.upm.miw.apaw_practice.domain.models.climbing.Climber;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimberPersistence {
    Climber readByEmail(String email);

    void delete(String email);
}
