package es.upm.miw.apaw_practice.domain.services.car_workshop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.car_workshop.CarComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class CarComponentServiceIT {

    @Autowired
    private CarComponentService carComponentService;

    @Test
    void testCreate() {
        CarComponent carComponent = new CarComponent("Hello Kitty Steering Wheel", new BigDecimal("100.0"), 100);
        CarComponent result = this.carComponentService.create(carComponent);
        assertNotNull(result);
        assertEquals(result.getName(), carComponent.getName());
    }

    @Test
    void testCreateWithConflict() {
        CarComponent repeatedCarComponent = new CarComponent("Universal Belt", new BigDecimal("20.0"), 100);
        assertThrows(ConflictException.class, () -> {
            this.carComponentService.create(repeatedCarComponent);
        });
    }

}
