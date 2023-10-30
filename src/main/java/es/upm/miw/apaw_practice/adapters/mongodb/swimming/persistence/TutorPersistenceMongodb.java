package es.upm.miw.apaw_practice.adapters.mongodb.swimming.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.swimming.daos.TutorRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.swimming.Tutor;
import es.upm.miw.apaw_practice.domain.persistence_ports.swimming.TutorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tutorPersistence")
public class TutorPersistenceMongodb implements TutorPersistence {

    private final TutorRepository tutorRepository;

    @Autowired
    public TutorPersistenceMongodb(TutorRepository tutorRepository){
        this.tutorRepository = tutorRepository;
    }

    @Override
    public Tutor readByAppellation(String appellation) {
        return this.tutorRepository.findByAppellation(appellation)
                .orElseThrow(() -> new NotFoundException("Tutor appellation: " + appellation))
                .toTutor();
    }
}
