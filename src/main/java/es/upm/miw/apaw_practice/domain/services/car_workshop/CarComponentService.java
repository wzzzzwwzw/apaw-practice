package es.upm.miw.apaw_practice.domain.services.car_workshop;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.car_workshop.CarComponent;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop.CarComponentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarComponentService {

    private final CarComponentPersistence carComponentPersistence;

    @Autowired
    public CarComponentService(CarComponentPersistence carComponentPersistence) {
        this.carComponentPersistence = carComponentPersistence;
    }

    public CarComponent create(CarComponent carComponent) {
        this.assertNameNotExist(carComponent.getName());
        return this.carComponentPersistence.create(carComponent);
    }

    public void assertNameNotExist(String name) {
        if (this.carComponentPersistence.existsName(name)) {
            throw new ConflictException("Name exist: " + name);
        }
    }
}
