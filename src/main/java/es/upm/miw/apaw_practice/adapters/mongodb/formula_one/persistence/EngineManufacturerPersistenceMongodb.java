package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.EngineManufacturerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.RaceRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos.TeamRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.EngineManufacturerEntity;
import es.upm.miw.apaw_practice.domain.models.formula_one.EngineManufacturer;
import es.upm.miw.apaw_practice.domain.persistence_ports.formula_one.EngineManufacturerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("engineManufacturerPersistence")
public class EngineManufacturerPersistenceMongodb implements EngineManufacturerPersistence {

    private final EngineManufacturerRepository engineManufacturerRepository;
    private final RaceRepository raceRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public EngineManufacturerPersistenceMongodb(EngineManufacturerRepository engineManufacturerRepository,
                                                RaceRepository raceRepository, TeamRepository teamRepository) {
        this.engineManufacturerRepository = engineManufacturerRepository;
        this.raceRepository = raceRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public EngineManufacturer create(EngineManufacturer engineManufacturer) {
        return this.engineManufacturerRepository
                .save(new EngineManufacturerEntity(engineManufacturer))
                .toEngineManufacturer();
    }

    @Override
    public boolean existEngineManufacturer(String manufacturerName) {
        return this.engineManufacturerRepository
                .findByManufacturerName(manufacturerName)
                .isPresent();
    }

    @Override
    public Stream<String> findManufacturersNamesByHostCountry(String hostCountry) {
        return this.teamRepository.findAll().stream()
                .filter(teamEntity -> teamEntity.getDriverEntities().stream()
                        .anyMatch(
                                this.raceRepository.findAll().stream()
                                        .filter(raceEntity -> hostCountry.equals(raceEntity.getHostCountry()))
                                        .flatMap(raceEntity -> raceEntity.getRaceDriverEntities().stream())
                                        .toList()::contains
                        )
                )
                .map(teamEntity -> teamEntity.getEngineManufacturerEntity().getManufacturerName()).distinct();
    }
}
