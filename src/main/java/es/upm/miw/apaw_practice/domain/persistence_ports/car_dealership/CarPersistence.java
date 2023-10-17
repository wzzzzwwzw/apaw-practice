package es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.Car;

import java.math.BigDecimal;

public interface CarPersistence {
    Car readByChassis(String chassis);

    BigDecimal findAverageCarPriceByName(String name);
}
