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

    public Academy read(String name) {
        return this.academyPersistence.readByName(name);
    }

    public void delete(String name) {
        this.academyPersistence.deleteByName(name);
    }

    public Academy updateAddress(String name, String address) {
        Academy academy = this.academyPersistence.readByName(name);
        academy.setAddress(address);
        return this.academyPersistence.updateAddress(academy);
    }
}
