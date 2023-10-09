package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store;

import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.daos.FurnitureStoreRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.daos.ManagerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.daos.MaterialRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities.FurnitureEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities.FurnitureStoreEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities.ManagerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities.MaterialEntity;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Manager;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Material;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Service
public class FurnitureStoreSeederService {
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private FurnitureStoreRepository furnitureStoreRepository;
    @Autowired
    private ManagerRepository managerRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Furniture store Initial Load -----------");
        MaterialEntity[] materials = {
                new MaterialEntity(new Material("madera", "roble", 8)),
                new MaterialEntity(new Material("plástico", "polipropileno", 5)),
                new MaterialEntity(new Material("metal", "aluminio", 7)),
                new MaterialEntity(new Material("vidrio", "laminado", 4)),
        };
        this.materialRepository.saveAll(Arrays.asList(materials));
        ManagerEntity[] managers = {
                new ManagerEntity(new Manager("111222333444", "José", false)),
                new ManagerEntity(new Manager("456745674567", "María", true)),
                new ManagerEntity(new Manager("123456789012", "Fernando", true)),
        };
        this.managerRepository.saveAll(Arrays.asList(managers));
        FurnitureEntity[] furnitures = {
                new FurnitureEntity("lámpara de pie", new BigDecimal("35.99"), List.of(materials[0], materials[1])),
                new FurnitureEntity("mesa extensible", new BigDecimal("150"), List.of(materials[0])),
                new FurnitureEntity("alfombra para cajón 180 cm ", new BigDecimal("4.5"), List.of(materials[1], materials[2], materials[3])),
                new FurnitureEntity("mueble salon 270x190 cm", new BigDecimal("877"), List.of()),
        };
        FurnitureStoreEntity[] furnitureStoreEntities = {
                new FurnitureStoreEntity("ikia", LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.of(9, 0)),
                        LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.of(20, 30)), managers[1],
                        Arrays.asList(furnitures[0], furnitures[2], furnitures[3])),

                new FurnitureStoreEntity("muebles vintage", LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.of(10, 0)),
                        LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.of(21, 0)), managers[0],
                        Arrays.asList(furnitures[0], furnitures[1])),
        };
        this.furnitureStoreRepository.saveAll(Arrays.asList(furnitureStoreEntities));
    }

    public void deleteAll() {
        this.furnitureStoreRepository.deleteAll();
        this.managerRepository.deleteAll();
        this.materialRepository.deleteAll();
    }

}
