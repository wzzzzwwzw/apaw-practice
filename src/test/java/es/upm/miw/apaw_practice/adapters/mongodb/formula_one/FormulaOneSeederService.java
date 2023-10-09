package es.upm.miw.apaw_practice.adapters.mongodb.formula_one;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.DriverRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.DrivingStyleRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.RaceRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.TeamRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.DriverEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.RaceEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.TeamEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Service
public class FormulaOneSeederService {

    @Autowired
    private DrivingStyleRepository drivingStyleRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private RaceRepository raceRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Formula One Initial Load -----------");
        DrivingStyleEntity[] drivingStyles = {
                new DrivingStyleEntity(95, 98, 92, 85, 82),
                new DrivingStyleEntity(80, 78, 75, 99, 96),
                new DrivingStyleEntity(90, 97, 95, 90, 90),
                new DrivingStyleEntity(82, 62, 60, 72, 71),
                new DrivingStyleEntity(89, 96, 90, 83, 85),
                new DrivingStyleEntity(88, 82, 80, 79, 80),
        };
        this.drivingStyleRepository.saveAll(Arrays.asList(drivingStyles));

        DriverEntity[] drivers = {
                new DriverEntity(1, "Max Verstappen", "Netherlands", drivingStyles[0]),
                new DriverEntity(11, "Sergio Pérez", "Mexico", drivingStyles[1]),
                new DriverEntity(14, "Fernando Alonso", "Spain", drivingStyles[2]),
                new DriverEntity(18, "Lance Stroll", "Canada", drivingStyles[3]),
                new DriverEntity(44, "Lewis Hamilton", "United Kingdom", drivingStyles[4]),
                new DriverEntity(63, "George Russell", "United Kingdom", drivingStyles[5]),
        };
        this.driverRepository.saveAll(Arrays.asList(drivers));

        TeamEntity[] teams = {
                new TeamEntity("Red Bull Racing", "Austria", Arrays.asList(drivers[0], drivers[1])),
                new TeamEntity("Aston Martin", "United Kingdom", Arrays.asList(drivers[2], drivers[3])),
                new TeamEntity("Mercedes", "Germany", Arrays.asList(drivers[4], drivers[5])),
        };
        this.teamRepository.saveAll(Arrays.asList(teams));

        RaceEntity[] races = {
                new RaceEntity("Albert Park", "Australia", LocalDate.of(2023, 4, 2), List.of(drivers)),
                new RaceEntity("Hermanos Rodríguez", "Mexico", LocalDate.of(2023, 10, 29), List.of(drivers)),
        };
        this.raceRepository.saveAll(Arrays.asList(races));
    }

    public void deleteAll() {
        this.drivingStyleRepository.deleteAll();
        this.driverRepository.deleteAll();
        this.teamRepository.deleteAll();
        this.raceRepository.deleteAll();
    }

}
