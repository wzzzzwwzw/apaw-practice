package es.upm.miw.apaw_practice.domain.services.subway;

import es.upm.miw.apaw_practice.domain.models.subway.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.upm.miw.apaw_practice.domain.persistence_ports.subway.SchedulePersistence;

import java.util.stream.Stream;

@Service
public class ScheduleService {

    private final SchedulePersistence schedulePersistence;

    @Autowired

    public ScheduleService(SchedulePersistence schedulePersistence) {
        this.schedulePersistence = schedulePersistence;
    }

    public Stream<Schedule> update(Float newFrecuency) {
        return this.schedulePersistence.update(newFrecuency);
    }

    public Stream<Schedule> readAll() {
        return this.schedulePersistence.readAll();
    }
}
