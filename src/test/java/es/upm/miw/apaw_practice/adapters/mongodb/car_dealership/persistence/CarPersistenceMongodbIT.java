package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.car_dealership.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class CarPersistenceMongodbIT {

    @Autowired
    private  CarPersistenceMongoDB carPersistence;

    @Test
    void testReadByChassisNotFound() {
        assertThrows(NotFoundException.class, () -> this.carPersistence.readByChassis("0"));
    }
    @Test
    void testReadByChassis() {
        Car car = this.carPersistence.readByChassis("HV30-0169266692781");
        assertNotNull(car);
        assertEquals(0, BigDecimal.valueOf(44000).compareTo(car.getPrice()));
        assertTrue(car.getSold());

        assertTrue(car.getFabricationDate().isBefore(LocalDate.now()));

        assertEquals("Camry", car.getCarModel().getName());
        assertEquals("Toyota", car.getCarModel().getBrand());

        assertNotNull(car.getCarModel().getCreateDate());

        assertNotNull(car.getSellerList());
    }

    @Test
    void testFindAverageCarPriceByName() {
        BigDecimal average = this.carPersistence.findAverageCarPriceByName("Asier");
        assertNotNull(average);
        assertEquals(0, new BigDecimal("29466.66").compareTo(average));
    }
}
