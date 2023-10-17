package es.upm.miw.apaw_practice.domain.persistence_ports.climbing;

import es.upm.miw.apaw_practice.domain.models.climbing.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaPersistence {
    Area readByName(String name);

    Area update(Area area);

    List<Area> findAll();
}
