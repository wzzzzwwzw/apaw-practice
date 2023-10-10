package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.daos.CarToRepairRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities.CarToRepairEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.car_workshop.CarToRepair;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop.CarToRepairPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("carToRepairPersistence")
public class CarToRepairPersistenceMongodb implements CarToRepairPersistence {

    private final CarToRepairRepository carToRepairRepository;

    @Autowired
    public CarToRepairPersistenceMongodb(CarToRepairRepository carToRepairRepository) {
        this.carToRepairRepository = carToRepairRepository;
    }

    @Override
    public CarToRepair readByRegistrationNumber(String registrationNumber) {
        return this.carToRepairRepository
                .findByRegistrationNumber(registrationNumber)
                .orElseThrow(() -> new NotFoundException("Not found car with registration number: " + registrationNumber))
                .toCarToRepair();
    }

    @Override
    public CarToRepair update(CarToRepair carToRepair) {
        CarToRepairEntity carToRepairEntity = this.carToRepairRepository
                .findByRegistrationNumber(carToRepair.getRegistrationNumber())
                .orElseThrow(() -> new NotFoundException("Not found car with registration number: " + carToRepair.getRegistrationNumber()));
        carToRepairEntity.setModel(carToRepair.getModel());
        return this.carToRepairRepository
                .save(carToRepairEntity)
                .toCarToRepair();
    }
}
