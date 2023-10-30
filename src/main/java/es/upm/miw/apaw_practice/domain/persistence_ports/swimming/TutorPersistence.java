package es.upm.miw.apaw_practice.domain.persistence_ports.swimming;

import es.upm.miw.apaw_practice.domain.models.swimming.Tutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorPersistence {
    Tutor readByAppellation(String appellation);
}
