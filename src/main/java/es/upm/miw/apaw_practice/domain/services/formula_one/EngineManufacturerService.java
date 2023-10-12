package es.upm.miw.apaw_practice.domain.services.formula_one;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.formula_one.EngineManufacturer;
import es.upm.miw.apaw_practice.domain.persistence_ports.formula_one.EngineManufacturerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class EngineManufacturerService {

    private final EngineManufacturerPersistence engineManufacturerPersistence;

    @Autowired
    public EngineManufacturerService(EngineManufacturerPersistence engineManufacturerPersistence) {
        this.engineManufacturerPersistence = engineManufacturerPersistence;
    }

    public EngineManufacturer create(EngineManufacturer engineManufacturer) {
        this.assertEngineManufacturerNotExist(engineManufacturer.getManufacturerName());
        return this.engineManufacturerPersistence.create(engineManufacturer);
    }

    private void assertEngineManufacturerNotExist(String manufacturerName) {
        if (this.engineManufacturerPersistence.existEngineManufacturer(manufacturerName)) {
            throw new ConflictException("Engine manufacturer exist: " + manufacturerName);
        }
    }

    public Stream<String> findManufacturersNamesByHostCountry(String hostCountry) {
    }
}
