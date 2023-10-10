package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.RaceRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.RaceEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.formula_one.Race;
import es.upm.miw.apaw_practice.domain.persistence_ports.formula_one.RacePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("racePersistence")
public class RacePersistenceMongodb implements RacePersistence {

    private final RaceRepository raceRepository;

    @Autowired
    public RacePersistenceMongodb(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public Race readByCircuitName(String circuitName) {
        return this.raceRepository.findByCircuitName(circuitName)
                .orElseThrow(() -> new NotFoundException("Circuit name: " + circuitName))
                .toRace();

    }

    @Override
    public Race update(Race race) {
        RaceEntity raceEntity = this.raceRepository
                .findByCircuitName(race.getCircuitName())
                .orElseThrow(() -> new NotFoundException("Circuit name: " + race.getCircuitName()));
        raceEntity.setLaps(race.getLaps());
        return this.raceRepository.save(raceEntity).toRace();
    }
}
