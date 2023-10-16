package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.persistence;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos.AquariumRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.AquariumEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import es.upm.miw.apaw_practice.domain.persistence_ports.aquarium.AquariumPersistence;

@Repository("aquariumPersistence")
public class AquariumPersistenceMongodb implements AquariumPersistence {
    private final AquariumRepository aquariumRepository;
    @Autowired
    public AquariumPersistenceMongodb(AquariumRepository aquariumRepository){
        this.aquariumRepository = aquariumRepository;
    }
    @Override
    public Aquarium read(String description){
        return this.aquariumRepository
                .findByDescription(description)
                .orElseThrow(()-> new NotFoundException("Aquarium description not found:" +description))
                .toAquarium();
    }


    @Override
    public boolean existsAquariumDescription(String description) {
        return this.aquariumRepository
                .findByDescription(description)
                .isPresent();
    }

    @Override
    public Aquarium create(Aquarium aquarium) {
        return this.aquariumRepository
                .save(new AquariumEntity(aquarium))
                .toAquarium();
    }
    @Override
    public Aquarium update(Aquarium aquarium){
        AquariumEntity aquariumEntity = this.aquariumRepository
                .findByDescription(aquarium.getDescription())
                .orElseThrow(()-> new NotFoundException("Aquarium with description"+ aquarium.getDescription()));
        aquariumEntity.fromAquarium(aquarium);
        return this.aquariumRepository
                .save(aquariumEntity)
                .toAquarium();
    }
}
