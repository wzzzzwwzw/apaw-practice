package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.DriverRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.DriverEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.formula_one.Driver;
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

    @Override
    public Driver readByNumber(Integer number) {
        return this.driverRepository
                .findByNumber(number)
                .orElseThrow(() -> new NotFoundException("Reading driver number: " + number))
                .toDriver();
    }

    @Override
    public Driver update(Driver driver) {
        DriverEntity driverEntity = this.driverRepository
                .findByNumber(driver.getNumber())
                .orElseThrow(() -> new NotFoundException("Updating driver number: " + driver.getNumber()));
        driverEntity.fromDriver(driver);
        return this.driverRepository
                .save(driverEntity)
                .toDriver();
    }
}
