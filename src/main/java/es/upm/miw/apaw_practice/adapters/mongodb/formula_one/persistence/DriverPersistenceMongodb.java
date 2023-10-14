package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.DriverRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.TeamRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.DriverEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.formula_one.Driver;
import es.upm.miw.apaw_practice.domain.persistence_ports.formula_one.DriverPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository("driverPersistence")
public class DriverPersistenceMongodb implements DriverPersistence {

    private final DriverRepository driverRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public DriverPersistenceMongodb(DriverRepository driverRepository, TeamRepository teamRepository) {
        this.driverRepository = driverRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public Driver readByNumber(Integer number) {
        return this.driverRepository
                .findByNumber(number)
                .orElseThrow(() -> new NotFoundException("Driver with number: " + number))
                .toDriver();
    }

    @Override
    public Driver update(Driver driver) {
        DriverEntity driverEntity = this.driverRepository
                .findByNumber(driver.getNumber())
                .orElseThrow(() -> new NotFoundException("Driver with number: " + driver.getNumber()));
        driverEntity.fromDriver(driver);
        return this.driverRepository
                .save(driverEntity)
                .toDriver();
    }

    @Override
    public Float findTotalPointsByEnginesBuiltIn(String enginesBuiltIn) {
        return this.teamRepository.findAll().stream()
                .filter(teamEntity -> enginesBuiltIn.equals(teamEntity.getEngineManufacturerEntity().getEngineBuiltIn()))
                .flatMap(teamEntity -> teamEntity.getDriverEntities().stream())
                .map(DriverEntity::getPoints)
                .filter(Objects::nonNull).reduce(Float::sum).orElse(0f);
    }
}
