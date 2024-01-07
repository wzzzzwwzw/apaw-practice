package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.daos.AcademyRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Academy;
import es.upm.miw.apaw_practice.domain.persistence_ports.padel_academy.AcademyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("academyPersistence")
public class AcademyPersistenceMongodb implements AcademyPersistence {
    private final AcademyRepository academyRepository;

    @Autowired
    public AcademyPersistenceMongodb(AcademyRepository academyRepository) {
        this.academyRepository = academyRepository;
    }

    @Override
    public Academy readByName(String name) {
        return this.academyRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Academy with name " + name + " not found."))
                .toAcademy();
    }

    @Override
    public void deleteByName(String name) {
        this.academyRepository.deleteByName(name);
    }
}
