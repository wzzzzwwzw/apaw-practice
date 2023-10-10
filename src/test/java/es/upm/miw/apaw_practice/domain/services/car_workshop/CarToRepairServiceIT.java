package es.upm.miw.apaw_practice.domain.services.car_workshop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.car_workshop.CarToRepair;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class CarToRepairServiceIT {
    @Autowired
    private CarToRepairService carToRepairService;


    @Test
    void testUpdate() {
        CarToRepair carToRepairUpdated = this.carToRepairService.updateModel("7687FDR", "Duster");
        assertNotNull(carToRepairUpdated);
        assertEquals(carToRepairUpdated.getRegistrationNumber(), "7687FDR");
        assertEquals(carToRepairUpdated.getModel(), "Duster");
    }

    @Test
    void testUpdateWithNoExistingCar() {
        assertThrows(NotFoundException.class, () -> {
            this.carToRepairService.updateModel("notfoundlol", "Twingo");
        });
    }
}
