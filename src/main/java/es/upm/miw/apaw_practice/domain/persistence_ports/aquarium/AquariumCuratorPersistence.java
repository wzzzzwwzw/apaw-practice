package es.upm.miw.apaw_practice.domain.persistence_ports.aquarium;
import es.upm.miw.apaw_practice.domain.models.aquarium.AquariumCurator;
import es.upm.miw.apaw_practice.domain.models.aquarium.Fishpond;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;
import org.springframework.stereotype.Repository;
import java.util.List;
public interface AquariumCuratorPersistence {
    AquariumCurator readByName(String name);
    AquariumCurator update (AquariumCurator aquariumCurator);
}
