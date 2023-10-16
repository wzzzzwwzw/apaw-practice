package es.upm.miw.apaw_practice.domain.persistence_ports.climbing;

import es.upm.miw.apaw_practice.domain.models.climbing.Expedition;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpeditionPersistence {
    Expedition create(Expedition expedition);

    Expedition readByIdentifier(String identifier);

    Expedition update(Expedition expedition);
}
