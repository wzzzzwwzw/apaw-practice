package es.upm.miw.apaw_practice.domain.persistence_ports.subway;

import es.upm.miw.apaw_practice.domain.models.subway.Station;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface StationPersistence {

    Stream<Station> readAll();

    Station create(Station station);

    Station readByName(String station);
}
