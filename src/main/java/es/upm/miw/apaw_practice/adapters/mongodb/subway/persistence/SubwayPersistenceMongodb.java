package es.upm.miw.apaw_practice.adapters.mongodb.subway.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.subway.daos.ScheduleRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.daos.SubwayRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.SubwayEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.subway.Line;
import es.upm.miw.apaw_practice.domain.models.subway.Subway;
import es.upm.miw.apaw_practice.domain.persistence_ports.subway.SubwayPersistence;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("subwayPersistence")
public class SubwayPersistenceMongodb implements SubwayPersistence {
    private final SubwayRepository subwayRepository;

    private final ScheduleRepository scheduleRepository;


    public SubwayPersistenceMongodb(SubwayRepository subwayRepository, ScheduleRepository scheduleRepository) {
        this.subwayRepository = subwayRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Stream<Subway> readAll() {
        return this.subwayRepository.findAll().stream()
                .map(SubwayEntity::toSubway);
    }

    @Override
    public Subway readByCity(String city) {
        return this.subwayRepository.findByCity(city)
                .orElseThrow(() -> new NotFoundException(" City : " + city))
                .toSubway();
    }

    public Line findLineByCityAndLabel(String city, String lineLabel) {
        return this.subwayRepository.findByCity(city)
                .orElseThrow(() -> new NotFoundException(" City : " + city))
                .getLines().stream()
                .filter(line -> lineLabel.equals(line.getLabel()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(" Line : " + lineLabel))
                .toLine();
    }


}
