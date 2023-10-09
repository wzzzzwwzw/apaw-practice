package es.upm.miw.apaw_practice.domain.services.formula_one;

import es.upm.miw.apaw_practice.domain.persistence_ports.formula_one.EngineManufacturerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EngineManufacturerService {

    private final EngineManufacturerPersistence engineManufacturerPersistence;

    @Autowired
    public EngineManufacturerService(EngineManufacturerPersistence engineManufacturerPersistence) {
        this.engineManufacturerPersistence = engineManufacturerPersistence;
    }
}
