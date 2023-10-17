package es.upm.miw.apaw_practice.adapters.mongodb.subway.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.subway.daos.SubwayRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.LineEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.StationEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.SubwayEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.subway.Line;
import es.upm.miw.apaw_practice.domain.models.subway.Station;
import es.upm.miw.apaw_practice.domain.models.subway.Subway;
import es.upm.miw.apaw_practice.domain.persistence_ports.subway.SubwayPersistence;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository("subwayPersistence")
public class SubwayPersistenceMongodb implements SubwayPersistence {
    private final SubwayRepository subwayRepository;

    public SubwayPersistenceMongodb(SubwayRepository subwayRepository) {
        this.subwayRepository = subwayRepository;
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

    @Override
    public Subway update(Subway subway) {
        SubwayEntity subwayEntity = this.subwayRepository
                .findByCity(subway.getCity())
                .orElseThrow(() -> new NotFoundException("Subway city:" + subway.getCity()));
        List<LineEntity> lines = subway.getLines().stream()
                .map(line -> new LineEntity(
                        line.getLabel(),
                        line.getColor(),
                        line.isWorking(),
                        subwayEntity.getLines().get(0).getSchedule(),
                        line.getStations().stream()
                                .map(station -> new StationEntity(
                                        new Station(
                                                station.getName(),
                                                station.getOrder(),
                                                station.isOpen()
                                        )
                                )).toList()
                )).toList();
        subwayEntity.setLines(lines);
        return this.subwayRepository.save(subwayEntity).toSubway();
    }
}
