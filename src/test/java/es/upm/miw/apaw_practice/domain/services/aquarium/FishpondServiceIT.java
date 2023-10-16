package es.upm.miw.apaw_practice.domain.services.aquarium;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.AquariumSeederService;
import es.upm.miw.apaw_practice.domain.persistence_ports.aquarium.FishpondPersistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
@TestConfig
public class FishpondServiceIT {
    @Autowired
    private FishpondService fishpondService;
    @Autowired
    private FishpondPersistence fishpondPersistence;
    @Autowired
    private AquariumSeederService aquariumSeederService;
    @AfterEach
    void resetDataBase(){
        this.aquariumSeederService.deleteAll();
        this.aquariumSeederService.seedDatabase();
    }
    @Test
    void testDelete(){
        this.fishpondService.delete("First floor");
    }
}
