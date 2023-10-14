package es.upm.miw.apaw_practice.adapters.mongodb.stable;

import es.upm.miw.apaw_practice.adapters.mongodb.stable.daos.CareTaskRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.stable.daos.HorseRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.stable.daos.KeeperRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.stable.daos.StableRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.stable.entities.CareTaskEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.stable.entities.HorseEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.stable.entities.KeeperEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.stable.entities.StableEntity;
import es.upm.miw.apaw_practice.domain.models.stable.CareTask;
import es.upm.miw.apaw_practice.domain.models.stable.Keeper;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.time.LocalDate;
import java.util.List;

@Service
public class StableSeederService {
    @Autowired
    private CareTaskRepository careTaskRepository;
    @Autowired
    private HorseRepository horseRepository;
    @Autowired
    private KeeperRepository keeperRepository;
    @Autowired
    private StableRepository stableRepository;
    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Stable Initial Load -----------");
        KeeperEntity[] keeperEntities = {
                new KeeperEntity(new Keeper("Keeper1", 26, LocalDate.of(2010, 1, 1), 21000.0)),
                new KeeperEntity(new Keeper("Keeper2", 27,  LocalDate.of(2011, 2, 2), 22000.0)),
                new KeeperEntity(new Keeper("Keeper3", 28,  LocalDate.of(2012, 3, 3), 23000.0)),
                new KeeperEntity(new Keeper("Keeper4", 29,  LocalDate.of(2014, 4, 4), 24000.0)),
                new KeeperEntity(new Keeper("Keeper5", 30,  LocalDate.of(2015, 5, 5), 25000.0)),
                new KeeperEntity(new Keeper("Keeper6", 31,  LocalDate.of(2016, 6, 6), 26000.0)),
                new KeeperEntity(new Keeper("Keeper7", 32,  LocalDate.of(2017, 7, 7), 27000.0)),
                new KeeperEntity(new Keeper("Keeper8", 33,  LocalDate.of(2018, 8, 9), 28000.0))
        };
        this.keeperRepository.saveAll(Arrays.asList(keeperEntities));
        CareTaskEntity[] careTaskEntities = {
                new CareTaskEntity(new CareTask("Description1", 1.0)),
                new CareTaskEntity(new CareTask("Description2", 2.0)),
                new CareTaskEntity(new CareTask("Description3", 1.0)),
                new CareTaskEntity(new CareTask("Description4", 1.0)),
                new CareTaskEntity(new CareTask("Description5", 2.0))
        };
        this.careTaskRepository.saveAll(Arrays.asList(careTaskEntities));
        HorseEntity[] horseEntities = {
                new HorseEntity("name1", 25, LocalDate.of(2001, 1, 1), "race1", 5.0, new BigDecimal("11000.0"), false, List.of(keeperEntities[0], keeperEntities[1]), careTaskEntities[0]),
                new HorseEntity("name2",26, LocalDate.of(2002, 2, 2), "race2", 6.0, new BigDecimal("12000.0"), true, List.of(keeperEntities[2], keeperEntities[3]), careTaskEntities[1]),
                new HorseEntity("name3", 27, LocalDate.of(2003, 3, 3), "race3",  7.0, new BigDecimal("14000.0"), false, List.of(keeperEntities[4], keeperEntities[5]), careTaskEntities[2]),
                new HorseEntity("name4", 28, LocalDate.of(2004, 4, 4), "race4", 8.0, new BigDecimal("15000.0"), true, List.of(keeperEntities[6], keeperEntities[7]), careTaskEntities[3])
        };
        this.horseRepository.saveAll(Arrays.asList(horseEntities));
        StableEntity[] stables = {
                new StableEntity("StableName1", "StableAddress1", 50, LocalDate.of(1999, 1, 1), Arrays.asList(horseEntities[0], horseEntities[1])),
                new StableEntity("StableName2", "StableAddress2", 80,  LocalDate.of(2000, 2, 2), Arrays.asList(horseEntities[2], horseEntities[3]))
        };
        this.stableRepository.saveAll(Arrays.asList(stables));
    }

    public void deleteAll() {
        this.stableRepository.deleteAll();
        this.horseRepository.deleteAll();
        this.keeperRepository.deleteAll();
        this.careTaskRepository.deleteAll();
    }

}
