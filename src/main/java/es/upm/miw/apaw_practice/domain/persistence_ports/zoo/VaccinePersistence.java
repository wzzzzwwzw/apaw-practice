package es.upm.miw.apaw_practice.domain.persistence_ports.zoo;

import es.upm.miw.apaw_practice.domain.models.zoo.Vaccine;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinePersistence {
    Vaccine findByIdentifierBatch(String identifierBatch);
}
