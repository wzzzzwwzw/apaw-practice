package es.upm.miw.apaw_practice.domain.services.aquarium;
import es.upm.miw.apaw_practice.domain.models.aquarium.Fishpond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.upm.miw.apaw_practice.domain.persistence_ports.aquarium.FishpondPersistence;
@Service
public class FishpondService {
    private final FishpondPersistence fishpondPersistence;
    @Autowired
    public FishpondService(FishpondPersistence fishpondPersistence) {
        this.fishpondPersistence = fishpondPersistence;
    }
    public void delete(String direction) {
        this.fishpondPersistence.delete(direction);
    }

}
