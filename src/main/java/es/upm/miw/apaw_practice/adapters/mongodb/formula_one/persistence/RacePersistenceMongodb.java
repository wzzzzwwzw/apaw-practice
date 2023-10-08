package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.RaceRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.IngredientRepository;
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
}
