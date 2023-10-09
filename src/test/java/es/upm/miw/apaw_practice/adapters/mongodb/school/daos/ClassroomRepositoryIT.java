package es.upm.miw.apaw_practice.adapters.mongodb.school.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.ClassroomEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ClassroomRepositoryIT {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.classroomRepository.findByLocation("classroom1").isPresent());
        ClassroomEntity subject1 = this.classroomRepository.findByLocation("classroom1").get();
        assertEquals(LocalDateTime.of(2019, 1, 5, 8, 30), subject1.getEntryHour());
        assertEquals(30, subject1.getLockers());
        assertTrue(subject1.getSmartBoard());

        assertTrue(this.classroomRepository.findByLocation("classroom2").isPresent());
        ClassroomEntity subject2 = this.classroomRepository.findByLocation("classroom2").get();
        assertNotEquals(subject1, subject2);
    }
}
