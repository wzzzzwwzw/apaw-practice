package es.upm.miw.apaw_practice.domain.services.school;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.school.SchoolSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.school.Classroom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ClassroomServiceIT {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private SchoolSeederService schoolSeederService;

    @AfterEach
    public void reseedDataBase () {
        this.schoolSeederService.deleteAll();
        this.schoolSeederService.seedDatabase();
    }

    @Test
    void testRead() {
        Classroom classroom = this.classroomService.read("classroom1");
        assertEquals("classroom1", classroom.getLocation());
        assertEquals(LocalDateTime.of(2019, 1, 5, 8, 30), classroom.getEntryHour());
        assertEquals(30, classroom.getLockers());
        assertTrue(classroom.getSmartBoard());
    }

    @Test
    void testAssertLocationNotExists() {
        assertThrows(ConflictException.class, () -> this.classroomService.assertLocationNotExist("classroom1"));
    }

    @Test
    void testCreate() {
        Classroom classroom = new Classroom("test", LocalDateTime.of(2019, 1, 5, 8, 30), true, 10);
        this.classroomService.create(classroom);
        Classroom savedClassroom = this.classroomService.read("test");
        assertEquals("test" , savedClassroom.getLocation());
        assertTrue(savedClassroom.getSmartBoard());
    }

    @Test
    void testUpdate() {
        List<Classroom> classrooms = Arrays.asList(
                new Classroom("classroom3", LocalDateTime.of(2000, 1, 1, 1, 1), false, 50),
                new Classroom("classroom4", LocalDateTime.of(2000, 1, 1, 1, 1), false, 80)
        );
        this.classroomService.updateLockers(classrooms.stream());
        assertEquals(50, this.classroomService.read("classroom3").getLockers());
        assertFalse(this.classroomService.read("classroom4").getSmartBoard());
    }
}

