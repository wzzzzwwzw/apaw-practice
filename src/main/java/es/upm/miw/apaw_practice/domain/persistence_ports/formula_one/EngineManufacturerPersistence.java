package es.upm.miw.apaw_practice.domain.persistence_ports.formula_one;

import es.upm.miw.apaw_practice.domain.models.formula_one.EngineManufacturer;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface EngineManufacturerPersistence {
    EngineManufacturer create(EngineManufacturer engineManufacturer);

    boolean existEngineManufacturer(String manufacturerName);

    Stream<String> findManufacturersNamesByHostCountry(String hostCountry);
}
