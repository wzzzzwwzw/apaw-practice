package es.upm.miw.apaw_practice.domain.persistence_ports.subway;

import es.upm.miw.apaw_practice.domain.models.subway.Line;
import es.upm.miw.apaw_practice.domain.models.subway.Subway;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface SubwayPersistence {
    Stream<Subway> readAll();

    Subway readByCity(String city);

    Line findLineByCityAndLabel(String city, String lineLabel);


}
