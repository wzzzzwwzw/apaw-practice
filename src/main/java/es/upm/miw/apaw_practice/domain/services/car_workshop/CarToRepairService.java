package es.upm.miw.apaw_practice.domain.services.car_workshop;

import es.upm.miw.apaw_practice.domain.models.car_workshop.CarToRepair;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop.CarToRepairPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarToRepairService {

    private CarToRepairPersistence carToRepairPersistence;

    @Autowired
    public CarToRepairService(CarToRepairPersistence carToRepairPersistence) {
        this.carToRepairPersistence = carToRepairPersistence;
    }


    public CarToRepair updateModel(String registrationNumber, String model) {
        CarToRepair carToRepair = carToRepairPersistence.readByRegistrationNumber(registrationNumber);
        carToRepair.setModel(model);
        return carToRepairPersistence.update(carToRepair);
    }
}
