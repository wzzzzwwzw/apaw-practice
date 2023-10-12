package es.upm.miw.apaw_practice.domain.services.climbing;

import es.upm.miw.apaw_practice.domain.models.climbing.Area;
import es.upm.miw.apaw_practice.domain.persistence_ports.climbing.AreaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaService {

    private final AreaPersistence areaPersistence;

    @Autowired
    public AreaService(AreaPersistence areaPersistence) {
        this.areaPersistence = areaPersistence;
    }

    public Area read(String name) {
        return this.areaPersistence.readByName(name);
    }
}
