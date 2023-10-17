package es.upm.miw.apaw_practice.domain.services.aquarium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.upm.miw.apaw_practice.domain.models.aquarium.AquariumCurator;
import es.upm.miw.apaw_practice.domain.persistence_ports.aquarium.AquariumCuratorPersistence;
@Service
public class AquariumCuratorService {
    private final AquariumCuratorPersistence aquariumCuratorPersistence;

    @Autowired
    public AquariumCuratorService(AquariumCuratorPersistence aquariumCuratorPersistence){
        this.aquariumCuratorPersistence = aquariumCuratorPersistence;
    }
    public AquariumCurator updatePosition(String name,String position){
        AquariumCurator aquariumCurator = this.aquariumCuratorPersistence.readByName(name);
        aquariumCurator.setPosition(position);
        return this.aquariumCuratorPersistence.update(aquariumCurator);
    }
}
