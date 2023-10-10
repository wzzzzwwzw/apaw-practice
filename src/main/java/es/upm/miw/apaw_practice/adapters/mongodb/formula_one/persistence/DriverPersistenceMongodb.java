package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.DriverRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.formula_one.DriverPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("driverPersistence")
public class DriverPersistenceMongodb implements DriverPersistence {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverPersistenceMongodb(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }
}
