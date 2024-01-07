package es.upm.miw.apaw_practice.domain.services.padel_academy;

import es.upm.miw.apaw_practice.domain.models.padel_academy.Academy;
import es.upm.miw.apaw_practice.domain.persistence_ports.padel_academy.AcademyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademyService {
    private final AcademyPersistence academyPersistence;

    @Autowired
    public AcademyService(AcademyPersistence academyPersistence) {
        this.academyPersistence = academyPersistence;
    }

    public Academy findByName(String name) {
        return this.academyPersistence.findByName(name);
    }
}
