package es.upm.miw.apaw_practice.domain.services.food_delivery;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Transport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class TransportServiceIT {

    @Autowired
    private TransportService transportService;

    @Test
    void testUpdateAvailable() {
        Transport transport = this.transportService.updateTransportAvalaible("T003", false);
        assertEquals(false, transport.getAvalaible());
        assertEquals(new BigDecimal("35.0"), transport.getCapacity());
        assertEquals("DEF456", transport.getLicensePlate());

    }

    @Test
    void testFindByEmailClient() {
        List<String> licencePlates = this.transportService.findByEmailClient("customer1@example.com").toList();
        assertEquals(2, licencePlates.size());
        assertEquals("ABC123", licencePlates.get(0));
        assertEquals("ABC123", licencePlates.get(1));


    }

}
