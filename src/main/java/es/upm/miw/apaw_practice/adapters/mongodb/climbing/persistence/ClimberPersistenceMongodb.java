package es.upm.miw.apaw_practice.adapters.mongodb.climbing.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.climbing.daos.ClimberRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.climbing.Climber;
import es.upm.miw.apaw_practice.domain.persistence_ports.climbing.ClimberPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("climberPersistence")
public class ClimberPersistenceMongodb implements ClimberPersistence {

    private final ClimberRepository climberRepository;

    @Autowired
    public ClimberPersistenceMongodb(ClimberRepository climberRepository) {
        this.climberRepository = climberRepository;
    }

    @Override
    public Climber readByEmail(String email) {
        return this.climberRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException(" Climber email: " + email))
                .toClimber();
    }

}
