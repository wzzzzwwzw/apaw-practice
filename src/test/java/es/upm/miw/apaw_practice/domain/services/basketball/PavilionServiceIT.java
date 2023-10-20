package es.upm.miw.apaw_practice.domain.services.basketball;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.basketball.Pavilion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestConfig
class PavilionServiceIT {
    @Autowired
    private PavilionService pavilionService;
    @Test
    void testCreatePavilion() {
        Pavilion pavilion = this.pavilionService.create(new Pavilion("pavilion3","location1",40));
        assertNotNull(pavilion);
        assertEquals("pavilion3", pavilion.getPavname());
        assertEquals("location1", pavilion.getDirection());
        assertEquals(40, pavilion.getCapacity());
    }
}
