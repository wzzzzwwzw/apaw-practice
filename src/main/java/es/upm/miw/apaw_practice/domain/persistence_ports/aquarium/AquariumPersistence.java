package es.upm.miw.apaw_practice.domain.persistence_ports.aquarium;
import org.springframework.stereotype.Repository;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;
@Repository
public interface AquariumPersistence {
    Aquarium read(String description);
    boolean existsAquariumDescription(String description);
    Aquarium create(Aquarium aquarium);
}
