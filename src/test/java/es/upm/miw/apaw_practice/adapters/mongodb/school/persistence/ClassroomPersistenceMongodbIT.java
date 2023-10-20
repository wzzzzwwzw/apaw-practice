package es.upm.miw.apaw_practice.adapters.mongodb.school.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.school.SchoolSeederService;
import es.upm.miw.apaw_practice.domain.models.school.Classroom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ClassroomPersistenceMongodbIT {

    @Autowired
    private ClassroomPersistenceMongodb classroomPersistenceMongodb;

    @Autowired
    private SchoolSeederService schoolSeederService;

    @AfterEach
    public void reseedDataBase () {
        this.schoolSeederService.deleteAll();
        this.schoolSeederService.seedDatabase();
    }

    @Test
    void testRead() {
        Classroom classroom = this.classroomPersistenceMongodb.read("classroom1");
        assertEquals("classroom1", classroom.getLocation());
        assertEquals(LocalDateTime.of(2019, 1, 5, 8, 30), classroom.getEntryHour());
        assertEquals(30, classroom.getLockers());
        assertTrue(classroom.getSmartBoard());
    }

    @Test
    void testExistLocation() {
        assertTrue(this.classroomPersistenceMongodb.existLocation("classroom1"));
        assertFalse(this.classroomPersistenceMongodb.existLocation("foo"));
    }

    @Test
    void testReadAll() {
        assertEquals(8 , this.classroomPersistenceMongodb.readAll().toList().size());
        assertEquals("classroom2" , this.classroomPersistenceMongodb.readAll().toList().get(1).getLocation());
    }

    @Test
    void testCreate() {
        Classroom classroom = new Classroom("test", LocalDateTime.of(2019, 1, 5, 8, 30), true, 10);
        this.classroomPersistenceMongodb.create(classroom);
        Classroom savedClassroom = this.classroomPersistenceMongodb.read("test");
        assertEquals("test" , savedClassroom.getLocation());
        assertTrue(savedClassroom.getSmartBoard());
    }

    @Test
    void testUpdate() {
        Classroom classroom = new Classroom("classroom1", LocalDateTime.of(2000, 5, 5, 5, 5), false, 40);
        this.classroomPersistenceMongodb.update("classroom1", classroom);
        assertEquals(40, this.classroomPersistenceMongodb.read("classroom1").getLockers());
    }
}
