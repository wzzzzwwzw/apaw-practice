package es.upm.miw.apaw_practice.adapters.mongodb.subway;

import es.upm.miw.apaw_practice.adapters.mongodb.subway.daos.ScheduleRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.daos.StationRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.daos.SubwayRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.LineEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.ScheduleEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.StationEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.SubwayEntity;
import es.upm.miw.apaw_practice.domain.models.subway.Schedule;
import es.upm.miw.apaw_practice.domain.models.subway.Station;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Service
public class SubwaySeederService {

    @Autowired
    private SubwayRepository subwayRepository;
    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Subway Initial Load -----------");
        StationEntity[] stations = {
                new StationEntity(new Station("Cuatro Caminos", "RED-1", true)),
                new StationEntity(new Station("Canal", "RED-2#ORANGE-2", true)),
                new StationEntity(new Station("Quevedo", "RED-3", true)),
                new StationEntity(new Station("Islas Filipinas", "ORANGE-1", true)),
                new StationEntity(new Station("Alonso Cano", "ORANGE-3", true))
        };
        this.stationRepository.saveAll(List.of(stations));

        ScheduleEntity schedule =
                new ScheduleEntity(new Schedule(
                        LocalDateTime.of(2023, Month.OCTOBER, 7, 6, 0, 0),
                        LocalDateTime.of(2023, Month.OCTOBER, 7, 1, 30, 0),
                        4F));

        this.scheduleRepository.save(schedule);

        LineEntity[] lines = {
                new LineEntity("Red Line", "RED", true, schedule,
                        List.of(stations[0], stations[1], stations[2])),
                new LineEntity("Orange Line", "ORANGE", true, schedule,
                        List.of(stations[3], stations[1], stations[4])),
        };

        SubwayEntity[] subways = {
                new SubwayEntity("Madrid", false, 1000, Arrays.asList(lines)),
        };
        this.subwayRepository.saveAll(List.of(subways));
    }

    public void deleteAll() {
        this.subwayRepository.deleteAll();
        this.stationRepository.deleteAll();
        this.scheduleRepository.deleteAll();
    }

}
