package es.upm.miw.apaw_practice.domain.services.aquarium;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;
import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestConfig
public class AquariumServiceIT {
    @Autowired
    private AquariumService aquariumService;
    @Test
    void testReadService(){
        Aquarium aquarium = aquariumService.read("River");
        assertNotNull(aquarium);
        assertEquals(3050.00,aquarium.getSize());
        assertEquals(4500,aquarium.getMaximumFishCapacity());
    }
}
