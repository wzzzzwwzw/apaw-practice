package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.DriverRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.RaceRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.DriverEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.RaceEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.formula_one.Race;
import es.upm.miw.apaw_practice.domain.persistence_ports.formula_one.RacePersistence;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("racePersistence")
public class RacePersistenceMongodb implements RacePersistence {

    private final RaceRepository raceRepository;
    private final DriverRepository driverRepository;

    @Autowired
    public RacePersistenceMongodb(RaceRepository raceRepository, DriverRepository driverRepository) {
        this.raceRepository = raceRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public Race readByCircuitName(String circuitName) {
        return this.raceRepository
                .findByCircuitName(circuitName)
                .orElseThrow(() -> new NotFoundException("Race with circuit: " + circuitName))
                .toRace();

    }

    @Override
    public Race update(Race race) {
        RaceEntity raceEntity = this.raceRepository
                .findByCircuitName(race.getCircuitName())
                .orElseThrow(() -> new NotFoundException("Race with circuit: " + race.getCircuitName()));
        BeanUtils.copyProperties(race, raceEntity, "raceDrivers");
        List<DriverEntity> raceDriversEntities = race.getRaceDrivers().stream()
                .map(driver -> {
                    DriverEntity driverEntity = this.driverRepository
                            .findByNumber(driver.getNumber())
                            .orElseThrow(() -> new NotFoundException("Driver number: " + driver.getNumber()));
                    driverEntity.fromDriver(driver);
                    return driverEntity;
                })
                .collect(Collectors.toList());
        raceEntity.setRaceDriverEntities(raceDriversEntities);
        return this.raceRepository
                .save(raceEntity)
                .toRace();
    }
}
