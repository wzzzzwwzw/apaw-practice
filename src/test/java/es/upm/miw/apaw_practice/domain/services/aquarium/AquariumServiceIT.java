package es.upm.miw.apaw_practice.domain.services.aquarium;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;
import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
@TestConfig
public class AquariumServiceIT {
    private static final String NOT_EXIST = "NotExistsTestName";
    @Autowired
    private AquariumService aquariumService;
    @Test
    void testReadService(){
        Aquarium aquarium = aquariumService.read("River");
        assertNotNull(aquarium);
        assertEquals(3050.00,aquarium.getSize());
        assertEquals(4500,aquarium.getMaximumFishCapacity());
    }
    @Test
    void testCreateAquarium() {
        Aquarium aquarium = this.aquariumService.create(new Aquarium(NOT_EXIST, 2000.55, 5000));
        assertNotNull(aquarium);
        assertEquals(NOT_EXIST, aquarium.getDescription());
        assertEquals(2000.55, aquarium.getSize());
        assertEquals(5000, aquarium.getMaximumFishCapacity());
    }

    @Test
    void testCreateAlreadyExistsAquarium() {
        Aquarium aquarium = new Aquarium("Sea", 2000.55, 5000);
        assertThrows(ConflictException.class, () -> this.aquariumService.create(aquarium));
    }
}
