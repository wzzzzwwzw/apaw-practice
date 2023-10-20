package es.upm.miw.apaw_practice.domain.persistence_ports.subway;

import es.upm.miw.apaw_practice.domain.models.subway.Schedule;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;


@Repository
public interface SchedulePersistence {

        Stream<Schedule> readAll();

        Stream<Schedule> update(Float newFrecuency);

        Float getAverageFrequencyByCity(String city);
}
