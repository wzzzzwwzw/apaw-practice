package es.upm.miw.apaw_practice.domain.services.aquarium;
import es.upm.miw.apaw_practice.domain.persistence_ports.aquarium.AquariumPersistence;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AquariumService {
    private final AquariumPersistence aquariumPersistence;
    @Autowired
    public AquariumService(AquariumPersistence aquariumPersistence){
        this.aquariumPersistence = aquariumPersistence;
    }
    public Aquarium read(String description) {
        return this.aquariumPersistence.read(description);
    }
}
