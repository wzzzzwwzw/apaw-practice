package es.upm.miw.apaw_practice.domain.persistence_ports.formula_one;

import es.upm.miw.apaw_practice.domain.models.formula_one.Driver;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverPersistence {
    Driver readByNumber(Integer number);

    Driver update(Driver driver);

    Float findTotalPointsByEnginesBuiltIn(String enginesBuiltIn);
}
