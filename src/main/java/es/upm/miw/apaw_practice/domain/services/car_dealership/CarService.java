package es.upm.miw.apaw_practice.domain.services.car_dealership;

import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.CarPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CarService {
    private final CarPersistence carPersistence;

    @Autowired
    public CarService(CarPersistence carPersistence) {
        this.carPersistence = carPersistence;
    }

    public String readCarModelName(String chassis) {
        return this.carPersistence.readByChassis(chassis)
                .getCarModel()
                .getName();
    }

    public BigDecimal findAverageCarPriceByName(String name) {
        return this.carPersistence.findAverageCarPriceByName(name);
    }
}
