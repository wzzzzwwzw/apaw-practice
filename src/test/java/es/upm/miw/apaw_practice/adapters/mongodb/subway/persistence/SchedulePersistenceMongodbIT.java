package es.upm.miw.apaw_practice.adapters.mongodb.subway.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.ScheduleEntity;
import es.upm.miw.apaw_practice.domain.models.subway.Schedule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class SchedulePersistenceMongodbIT {

    @Autowired
    private SchedulePersistenceMongodb schedulePersistenceMongodb;

    @Test
    void testRead() {
        Optional<Schedule> schedule = this.schedulePersistenceMongodb.readAll().findFirst();
        assertTrue(schedule.isPresent());
        assertEquals(4F, schedule.get().getFrequency());
    }

    @Test
    void testUpdate() {
        Optional<Schedule> schedule = this.schedulePersistenceMongodb.readAll().findFirst();
        assertTrue(schedule.isPresent());
        assertEquals(4F, schedule.get().getFrequency());
        this.schedulePersistenceMongodb.update(5.0F);
        Optional<Schedule> scheduleUpdated = this.schedulePersistenceMongodb.readAll().findFirst();
        assertTrue(scheduleUpdated.isPresent());
        assertEquals(5.0F, scheduleUpdated.get().getFrequency());
    }

}
