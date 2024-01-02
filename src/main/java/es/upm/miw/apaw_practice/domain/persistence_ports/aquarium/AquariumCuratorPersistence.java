package es.upm.miw.apaw_practice.domain.persistence_ports.aquarium;
import es.upm.miw.apaw_practice.domain.models.aquarium.AquariumCurator;
public interface AquariumCuratorPersistence {
    AquariumCurator readByName(String name);
    AquariumCurator update (AquariumCurator aquariumCurator);
    Double findAverageMaximumFishCapacity(String color);

}
