package es.upm.miw.apaw_practice.adapters.mongodb.school.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.school.SchoolSeederService;
import es.upm.miw.apaw_practice.domain.models.school.Subject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class SubjectPersistenceMongodbIT {

    @Autowired
    private SubjectPersistenceMongodb subjectPersistenceMongodb;

    @Autowired
    private SchoolSeederService schoolSeederService;

    @AfterEach
    public void reseedDataBase () {
        this.schoolSeederService.deleteAll();
        this.schoolSeederService.seedDatabase();
    }

    @Test
    void testRead() {
        Subject subject = this.subjectPersistenceMongodb.read("subject1");
        assertEquals("subject1", subject.getTitle());
        assertEquals("desc1", subject.getDescription());
        assertEquals(6, subject.getCredits());
        assertTrue(subject.getBilingual());
    }

    @Test
    void testExistTitle() {
        assertTrue(this.subjectPersistenceMongodb.existTitle("subject1"));
        assertFalse(this.subjectPersistenceMongodb.existTitle("foo"));
    }

    @Test
    void testReadAll() {
        assertEquals(9 , this.subjectPersistenceMongodb.readAll().toList().size());
        assertEquals("subject2" , this.subjectPersistenceMongodb.readAll().toList().get(1).getTitle());
    }

    @Test
    void testCreate() {
        Subject subject = new Subject("test", "desc", true, 10);
        this.subjectPersistenceMongodb.create(subject);
        Subject savedSubject = this.subjectPersistenceMongodb.read("test");
        assertEquals("test" , savedSubject.getTitle());
        assertTrue(savedSubject.getBilingual());
    }


    @Test
    void testDelete() {
        assertTrue(this.subjectPersistenceMongodb.existTitle("subject1"));
        this.subjectPersistenceMongodb.delete("subject1");
        assertFalse(this.subjectPersistenceMongodb.existTitle("subject1"));
    }
}
