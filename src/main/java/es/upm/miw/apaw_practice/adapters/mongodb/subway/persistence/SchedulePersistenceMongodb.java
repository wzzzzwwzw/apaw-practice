package es.upm.miw.apaw_practice.adapters.mongodb.subway.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.subway.daos.ScheduleRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.daos.SubwayRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.ScheduleEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.subway.Schedule;
import es.upm.miw.apaw_practice.domain.persistence_ports.subway.SchedulePersistence;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository("schedulePersistence")
public class SchedulePersistenceMongodb implements SchedulePersistence {

    private final ScheduleRepository scheduleRepository;

    private final SubwayRepository subwayRepository;

    public SchedulePersistenceMongodb(ScheduleRepository scheduleRepository, SubwayRepository subwayRepository) {
        this.scheduleRepository = scheduleRepository;
        this.subwayRepository = subwayRepository;
    }

    @Override
    public Stream<Schedule> readAll() {
        return this.scheduleRepository.findAll().stream()
                .map(ScheduleEntity::toSchedule);
    }

    @Override
    public Stream<Schedule> update(Float newFrequency) {
        List<ScheduleEntity> scheduleToUpdate = this.scheduleRepository.findAll();
        scheduleToUpdate.forEach(schedule -> schedule.setFrequency(newFrequency));

        return this.scheduleRepository.saveAll(scheduleToUpdate).stream()
                .map(ScheduleEntity::toSchedule);
    }

    @Override
    public Float getAverageFrequencyByCity(String city) {
        return (float) this.subwayRepository.findByCity(city)
                .orElseThrow(() -> new NotFoundException("Subway not found: " + city))
                .getLines().stream()
                .mapToDouble(line -> line.getSchedule().getFrequency())
                .average()
                .orElse(0.0);
    }

}
