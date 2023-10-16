package es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop;

import es.upm.miw.apaw_practice.domain.models.car_workshop.CarComponent;
import org.springframework.stereotype.Repository;

@Repository
public interface CarComponentPersistence {
    boolean existsName(String name);

    CarComponent create(CarComponent carComponent);
}
