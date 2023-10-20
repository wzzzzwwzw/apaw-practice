package es.upm.miw.apaw_practice.adapters.mongodb.subway.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.SubwaySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.ScheduleEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ScheduleRepositoryIT {
    @Autowired
    private SubwaySeederService subwaySeederService;
    @BeforeEach
    void resetDataBase() {
        this.subwaySeederService.deleteAll();
        this.subwaySeederService.seedDatabase();
    }
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Test
    void testRead() {
        Optional<ScheduleEntity> schedule = this.scheduleRepository.findAll().stream().findFirst();
        assertTrue(schedule.isPresent());
        assertEquals(4F, schedule.get().getFrequency());
    }

}
