package es.upm.miw.apaw_practice.adapters.mongodb.aquarium;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos.AquariumCuratorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos.AquariumRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.daos.FishpondRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.AquariumCuratorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.AquariumEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.FishpondEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.aquarium.entities.FishEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.logging.log4j.LogManager;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
@Service
public class AquariumSeederService {
    @Autowired
    private AquariumRepository aquariumRepository;
    @Autowired
    private AquariumCuratorRepository aquariumCuratorRepository;
    @Autowired
    private FishpondRepository fishpondRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Aquarium Initial Load -----------");

        FishEntity[] fishes ={
                new FishEntity("Catfish" ,"Black",LocalDate.of(2023,9,23)),
                new FishEntity("Carp" ,"Yellow",LocalDate.of(2023,2,3)),
                new FishEntity("Jellyfish" ,"Transparent",LocalDate.of(2023,3,6)),
        };

    AquariumEntity[] aquariums = {
            new AquariumEntity("Sea", 2000.55, 5000),
            new AquariumEntity("River", 3050.00, 4500),
            new AquariumEntity("Mix", 4000.88, 7000),
    };
        this.aquariumRepository.saveAll(Arrays.asList(aquariums));

        FishpondEntity[] fishponds ={
                new FishpondEntity("First floor",110, LocalDate.of(2023,8,13),List.of(fishes[0])),
                new FishpondEntity("Second floor",111, LocalDate.of(2023,4,4),List.of(fishes[1])),
                new FishpondEntity("Basic floor",112, LocalDate.of(2023,1,29),List.of(fishes[2])),
        };

        this.fishpondRepository.saveAll(Arrays.asList(fishponds));
    AquariumCuratorEntity[] aquariumCurators ={
            new AquariumCuratorEntity("Atlantis","Madrid",false,Arrays.asList(fishponds[1]),aquariums[0]),
            new AquariumCuratorEntity("Fish king","Madrid",false,Arrays.asList(fishponds[2]),aquariums[1]),
            new AquariumCuratorEntity("Oceanographic","Valencia",true,Arrays.asList(fishponds[2]),aquariums[1]),
    };
    this.aquariumCuratorRepository.saveAll(Arrays.asList(aquariumCurators));
}
    public void deleteAll() {
    this.aquariumRepository.deleteAll();
    this.aquariumCuratorRepository.deleteAll();
    this.fishpondRepository.deleteAll();
    }
    }