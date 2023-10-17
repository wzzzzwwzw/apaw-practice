package es.upm.miw.apaw_practice.adapters.mongodb.climbing;

import es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities.AreaEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities.ClimberEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities.ExpeditionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities.RouteEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.climbing.daos.AreaRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.climbing.daos.ClimberRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.climbing.daos.ExpeditionRepository;
import es.upm.miw.apaw_practice.domain.models.climbing.Expedition;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

@Service
public class ClimbingSeederService {

    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private ExpeditionRepository expeditionRepository;
    @Autowired
    private ClimberRepository climberRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Climbing Initial Load -----------");

        RouteEntity[] routes = {
                new RouteEntity("1", "Route 1", "Easy"),
                new RouteEntity("2", "Route 2", "Medium"),
                new RouteEntity("3", "Route 3", "Hard"),
                new RouteEntity("4", "Route 4", "Easy"),
                new RouteEntity("5", "Route 5", "Medium"),
                new RouteEntity("6", "Route 6", "Hard")
        };

        ExpeditionEntity[] expeditions = {
                new ExpeditionEntity("1", LocalDate.now(), new BigDecimal("1500.00")),
                new ExpeditionEntity("2", LocalDate.now().minusDays(5), new BigDecimal("500.00")),
                new ExpeditionEntity("3", LocalDate.now().minusDays(10), new BigDecimal("2000.00"))
        };
        this.expeditionRepository.saveAll(Arrays.asList(expeditions));

        AreaEntity[] areas = {
                new AreaEntity("Area 1", "Location 1", true, Arrays.asList(routes[0], routes[1]), expeditions[0]),
                new AreaEntity("Area 2", "Location 2", false, Arrays.asList(routes[2], routes[3]), expeditions[1]),
                new AreaEntity("Area 3", "Location 3", true, Arrays.asList(routes[4], routes[5]), expeditions[2])
        };
        this.areaRepository.saveAll(Arrays.asList(areas));

        ClimberEntity[] climbers = {
                new ClimberEntity("climber1@email.com", LocalDate.of(1990, 1, 1), "Beginner", Collections.singletonList(expeditions[0])),
                new ClimberEntity("climber2@email.com", LocalDate.of(1985, 6, 15), "Expert", Collections.singletonList(expeditions[1]))
        };
        this.climberRepository.saveAll(Arrays.asList(climbers));
    }

    public void deleteAll() {
        this.expeditionRepository.deleteAll();
        this.areaRepository.deleteAll();
        this.climberRepository.deleteAll();
    }
}
