package es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop;

import es.upm.miw.apaw_practice.domain.models.car_workshop.CarToRepair;
import org.springframework.stereotype.Repository;

@Repository
public interface CarToRepairPersistence {
    CarToRepair readByRegistrationNumber(String registrationNumber);

    CarToRepair updateModel(CarToRepair carToRepair);
}
