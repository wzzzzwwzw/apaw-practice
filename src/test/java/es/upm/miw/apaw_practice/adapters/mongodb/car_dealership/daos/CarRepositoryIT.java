package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.CarEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.SellerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class CarRepositoryIT {

    @Autowired
    private CarRepository carRepository;

    @Test
    void testFindByChassisNumber() {
        assertTrue(this.carRepository.findByChassisNumber("HV30-0169266692781").isPresent());
        CarEntity car = this.carRepository.findByChassisNumber("HV30-0169266692781").get();
        assertEquals(0, BigDecimal.valueOf(44000).compareTo(car.getPrice()));
        assertTrue(car.isSold());
        assertNotNull(car.getFabricationDate());
        assertTrue(car.getFabricationDate().isBefore(LocalDate.now()));

        assertEquals("Camry", car.getCarModelEntity().getModel());
        assertEquals("Toyota", car.getCarModelEntity().getBrand());
        assertNotNull(car.getCarModelEntity().getCreateDate());
        assertTrue(car.getCarModelEntity().getCreateDate().isBefore(LocalDate.now()));

        assertTrue(car.getSellerEntities().stream()
                .map(SellerEntity :: getName)
                .toList()
                .containsAll(Arrays.asList("Asier", "Javier")));

    }
}
