package es.upm.miw.apaw_practice.domain.services.formula_one;

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
}
