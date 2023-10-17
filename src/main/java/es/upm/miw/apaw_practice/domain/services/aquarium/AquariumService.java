package es.upm.miw.apaw_practice.domain.services.aquarium;
import es.upm.miw.apaw_practice.domain.persistence_ports.aquarium.AquariumPersistence;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;


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
    public Aquarium create(Aquarium aquarium) {
        this.assertAquariumDescriptionNotExists(aquarium.getDescription());
        return this.aquariumPersistence.create(aquarium);
    }

    private void assertAquariumDescriptionNotExists(String description) {
        if (this.aquariumPersistence.existsAquariumDescription(description)) {
            throw new ConflictException("Aquarium description already exists: " + description);
        }
    }
    public Aquarium updateDescription(String description, double size){
        Aquarium aquarium = this.aquariumPersistence.read(description);
        aquarium.setDescription(description);
        return this.aquariumPersistence.update(aquarium);
    }
}
