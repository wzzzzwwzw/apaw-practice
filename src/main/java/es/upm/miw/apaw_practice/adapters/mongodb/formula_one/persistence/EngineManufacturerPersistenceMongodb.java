package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.EngineManufacturerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.EngineManufacturerEntity;
import es.upm.miw.apaw_practice.domain.models.formula_one.EngineManufacturer;
import es.upm.miw.apaw_practice.domain.persistence_ports.formula_one.EngineManufacturerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("engineManufacturerPersistence")
public class EngineManufacturerPersistenceMongodb implements EngineManufacturerPersistence {

    private final EngineManufacturerRepository engineManufacturerRepository;

    @Autowired
    public EngineManufacturerPersistenceMongodb(EngineManufacturerRepository engineManufacturerRepository) {
        this.engineManufacturerRepository = engineManufacturerRepository;
    }

    @Override
    public EngineManufacturer create(EngineManufacturer engineManufacturer) {
        return this.engineManufacturerRepository
                .save(new EngineManufacturerEntity(engineManufacturer))
                .toEngineManufacturer();
    }

    @Override
    public boolean existEngineManufacturer(String manufacturerName) {
        return this.engineManufacturerRepository
                .findByManufacturerName(manufacturerName)
                .isPresent();
    }
}
