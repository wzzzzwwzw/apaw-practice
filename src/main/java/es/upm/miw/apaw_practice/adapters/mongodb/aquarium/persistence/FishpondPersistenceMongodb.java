package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.persistence;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos.FishpondRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.persistence_ports.aquarium.FishpondPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("fishpondPersistence")
public class FishpondPersistenceMongodb implements FishpondPersistence {
    private final FishpondRepository fishpondRepository;
    @Autowired
    public FishpondPersistenceMongodb(FishpondRepository fishpondRepository){
        this.fishpondRepository=fishpondRepository;
    }

    @Override
    public void delete(String direction) {
        this.fishpondRepository.deleteByDirection(direction);
    }
}
