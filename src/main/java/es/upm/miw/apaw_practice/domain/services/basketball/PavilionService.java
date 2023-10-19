package es.upm.miw.apaw_practice.domain.services.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Pavilion;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.PavilionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PavilionService {
    private final PavilionPersistence pavilionPersistence;
    @Autowired
    public PavilionService(PavilionPersistence pavilionPersistence) {
        this.pavilionPersistence = pavilionPersistence;
    }
    public Pavilion create(Pavilion pavilion) {
        return this.pavilionPersistence.create(pavilion);
    }
}