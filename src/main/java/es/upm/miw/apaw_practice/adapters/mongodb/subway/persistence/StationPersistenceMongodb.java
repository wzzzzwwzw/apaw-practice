package es.upm.miw.apaw_practice.adapters.mongodb.subway.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.subway.daos.StationRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.StationEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.subway.Station;
import es.upm.miw.apaw_practice.domain.persistence_ports.subway.StationPersistence;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("stationPersistence")
public class StationPersistenceMongodb implements StationPersistence {

    private final StationRepository stationRepository;

    public StationPersistenceMongodb(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public Stream<Station> readAll() {
        return this.stationRepository
                .findAll().stream()
                .map(StationEntity::toStation);
    }

    @Override
    public Station readByName(String station) {
        return this.stationRepository
                .findByName(station)
                .orElseThrow(() -> new NotFoundException("Station name: " + station))
                .toStation();
    }

    @Override
    public Station create(Station station) {
        return this.stationRepository
                .save(new StationEntity(station))
                .toStation();
    }

    @Override
    public void delete(String name) {
        this.stationRepository.deleteByName(name);
    }

}
