package es.upm.miw.apaw_practice.adapters.mongodb.aquarium.persistence;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos.AquariumCuratorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos.AquariumRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos.FishpondRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.AquariumCuratorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.AquariumEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.FishpondEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.aquarium.AquariumCurator;
import es.upm.miw.apaw_practice.domain.persistence_ports.aquarium.AquariumCuratorPersistence;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository("aquariumCuratorPersistence")
public class AquariumCuratorPersistenceMongodb implements AquariumCuratorPersistence {
    private final AquariumCuratorRepository aquariumCuratorRepository;
    private final AquariumRepository aquariumRepository;
    private final FishpondRepository fishpondRepository;
@Autowired
    public AquariumCuratorPersistenceMongodb(AquariumCuratorRepository aquariumCuratorRepository, AquariumRepository aquariumRepository, FishpondRepository fishpondRepository) {
        this.aquariumCuratorRepository = aquariumCuratorRepository;
    this.aquariumRepository = aquariumRepository;
    this.fishpondRepository = fishpondRepository;
}
@Override
public AquariumCurator readByName(String name){
    return this.aquariumCuratorRepository
            .findByName(name)
            .orElseThrow(()->new NotFoundException("AquariumCurator name:"+ name))
            .toAquariumCurator();
}
    @Override
    public AquariumCurator update(AquariumCurator aquariumCurator) {
        AquariumCuratorEntity aquariumCuratorEntity = this.aquariumCuratorRepository
                .findByName(aquariumCurator.getName())
                .orElseThrow(()->new NotFoundException("AquariumCurator with name"+aquariumCurator.getName()));
        aquariumCuratorEntity.setPosition(aquariumCurator.getPosition());
        aquariumCuratorEntity.setVacationState(aquariumCurator.isVacationState());
        aquariumCuratorEntity.setFishpondEntities(aquariumCurator.getFishponds().stream()
                .map(
                        fishpond -> new FishpondEntity
                                (this.fishpondRepository
                                .findByDirection(fishpond.getDirection())
                                .orElseThrow(()-> new NotFoundException("Direction:"+ fishpond.getDirection()))
                                        .toFishpond()
                )).toList());

        AquariumEntity aquariumEntity = aquariumRepository.findByDescription(aquariumCurator.getAquarium().getDescription())
                .orElseThrow(()-> new NotFoundException("Aquarium Description:"+ aquariumCurator.getAquarium().getDescription()));
        aquariumCuratorEntity.setAquariumEntity(aquariumEntity);
        return this.aquariumCuratorRepository.save(aquariumCuratorEntity).toAquariumCurator();



    }
   @Override
    public Double findAverageMaximumFishCapacity(String color){
    Integer maximumFishCapacityAdd = this.aquariumCuratorRepository.findAll().stream()
            .filter(aquariumCurator -> aquariumCurator.getFishpondEntity().getFishEntities().stream()
                   .anyMatch(fish -> fish.getColor().equals(color)))
            .map(aquariumCuratorEntity ->aquariumCuratorEntity.getAquariumEntity())
            .map(AquariumEntity::getMaximumFishCapacity)
            .reduce(Integer::sum).orElse(0);
    return maximumFishCapacityAdd.doubleValue()/this.aquariumCuratorRepository.findAll().stream()
            .filter(aquariumCurator -> aquariumCurator.getFishpondEntity().getFishEntities().stream()
                    .anyMatch(fish -> fish.getColor().equals(color)))
            .map(aquariumCuratorEntity ->aquariumCuratorEntity.getAquariumEntity())
            .toList().size();
}

}
