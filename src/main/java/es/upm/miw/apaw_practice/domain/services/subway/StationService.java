package es.upm.miw.apaw_practice.domain.services.subway;

import es.upm.miw.apaw_practice.domain.models.subway.Station;
import es.upm.miw.apaw_practice.domain.persistence_ports.subway.StationPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    private final StationPersistence stationPersistence;

    @Autowired
    public StationService(StationPersistence stationPersistence) {
        this.stationPersistence = stationPersistence;
    }

    public Station create(Station station) {
        return this.stationPersistence.create(station);
    }

    public Station readByName(String station) {
        return this.stationPersistence.readByName(station);
    }

    public void delete(String name) {
        this.stationPersistence.delete(name);
    }

}
