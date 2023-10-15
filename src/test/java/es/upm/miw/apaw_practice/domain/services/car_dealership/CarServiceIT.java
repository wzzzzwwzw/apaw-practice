package es.upm.miw.apaw_practice.domain.services.car_dealership;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class CarServiceIT {

    @Autowired
    private CarService carService;

    @Test
    void testReadCarModelName() {
        assertEquals("Camry", this.carService.readCarModelName("HV30-0169266692781"));
    }
}
