package es.upm.miw.apaw_practice.domain.services.climbing;

import es.upm.miw.apaw_practice.domain.models.climbing.Climber;
import es.upm.miw.apaw_practice.domain.persistence_ports.climbing.ClimberPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClimberService {

    private final ClimberPersistence climberPersistence;

    @Autowired
    public ClimberService(ClimberPersistence climberPersistence) {
        this.climberPersistence = climberPersistence;
    }

    public Climber read(String email) {
        return this.climberPersistence.readByEmail(email);
    }

    public void delete(String email) {
        this.climberPersistence.delete(email);
    }
}
