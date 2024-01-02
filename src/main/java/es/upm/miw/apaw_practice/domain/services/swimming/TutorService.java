package es.upm.miw.apaw_practice.domain.services.swimming;

import es.upm.miw.apaw_practice.domain.models.swimming.Tutor;
import es.upm.miw.apaw_practice.domain.persistence_ports.swimming.TutorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    private final TutorPersistence tutorPersistence;

    @Autowired
    public TutorService(TutorPersistence tutorPersistence){
        this.tutorPersistence = tutorPersistence;
    }

    public Tutor readByAppellation(String appellation){
        return this.tutorPersistence.readByAppellation(appellation);
    }

}
