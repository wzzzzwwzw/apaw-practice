package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.daos.CarComponentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities.CarComponentEntity;
import es.upm.miw.apaw_practice.domain.models.car_workshop.CarComponent;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop.CarComponentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("carComponentPersistence")
public class CarComponentPersistenceMongodb implements CarComponentPersistence {

    private final CarComponentRepository carComponentRepository;

    @Autowired
    public CarComponentPersistenceMongodb(CarComponentRepository carComponentRepository) {
        this.carComponentRepository = carComponentRepository;
    }

    @Override
    public boolean existsName(String name) {
        return this.carComponentRepository
                .findByName(name)
                .isPresent();
    }

    @Override
    public CarComponent create(CarComponent carComponent) {
        return this.carComponentRepository
                .save(new CarComponentEntity(carComponent))
                .toCarComponent();
    }
}
