package es.upm.miw.apaw_practice.domain.persistence_ports.climbing;

import es.upm.miw.apaw_practice.domain.models.climbing.Area;
import es.upm.miw.apaw_practice.domain.models.climbing.Route;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaPersistence {
    Area readByName(String name);

    Area update(Area area);
}
