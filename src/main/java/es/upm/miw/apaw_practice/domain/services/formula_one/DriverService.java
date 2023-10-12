package es.upm.miw.apaw_practice.domain.services.formula_one;

import es.upm.miw.apaw_practice.domain.models.formula_one.Driver;
import es.upm.miw.apaw_practice.domain.persistence_ports.formula_one.DriverPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    private final DriverPersistence driverPersistence;

    @Autowired
    public DriverService(DriverPersistence driverPersistence) {
        this.driverPersistence = driverPersistence;
    }

    public Driver updatePoints(Integer number, Float points) {
        Driver driver = this.driverPersistence.readByNumber(number);
        driver.setPoints(points);
        return this.driverPersistence.update(driver);
    }

    public Float findTotalPointsByEnginesBuiltIn(String enginesBuiltIn) {
        return this.driverPersistence.findTotalPointsByEnginesBuiltIn(enginesBuiltIn);
    }
}
