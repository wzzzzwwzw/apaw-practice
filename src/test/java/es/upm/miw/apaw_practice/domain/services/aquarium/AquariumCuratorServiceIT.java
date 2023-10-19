package es.upm.miw.apaw_practice.domain.services.aquarium;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.aquarium.AquariumCurator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestConfig
public class AquariumCuratorServiceIT {
    @Autowired
    private AquariumCuratorService aquariumCuratorService;
            @Test
    void testUpdate(){
                String name =  "Atlantis";
                String position = "Madrid";
                AquariumCurator aquariumCuratorChangePosition = aquariumCuratorService.updatePosition(name,position);
                assertNotNull(aquariumCuratorChangePosition);
                assertEquals(name,aquariumCuratorChangePosition.getName());
            }

}
