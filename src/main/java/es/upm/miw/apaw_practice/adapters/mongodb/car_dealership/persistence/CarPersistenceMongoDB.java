package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos.CarRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.CarEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.car_dealership.Car;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.CarPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Repository("carPersistence")
public class CarPersistenceMongoDB implements CarPersistence {

    private final CarRepository carRepository;

    @Autowired
    public CarPersistenceMongoDB(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car readByChassis(String chassis) {
        return this.carRepository
                .findByChassisNumber(chassis)
                .orElseThrow(() -> new NotFoundException("Car chassis: " + chassis))
                .toCar();
    }

    @Override
    public BigDecimal findAverageCarPriceByName(String name) {
        List<CarEntity> cars = this.carRepository.findAll()
                .stream()
                .filter(carEntity -> carEntity.getSellerEntities().stream()
                        .anyMatch(sellerEntity -> name.equals(sellerEntity.getName())))
                .toList();

        return cars.stream()
                .map(CarEntity::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(cars.size()), RoundingMode.HALF_EVEN);
    }
}
