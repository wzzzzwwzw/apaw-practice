package es.upm.miw.apaw_practice.adapters.mongodb.swimming.persistence;

import es.upm.miw.apaw_practice.TestConfig;

import es.upm.miw.apaw_practice.domain.models.swimming.Tutor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class TutorPersistenceMongodbIT {

    @Autowired
    private TutorPersistenceMongodb tutorPersistenceMongodb;

    @Test
    void testReadByAppellation() {
        Tutor tutor = this.tutorPersistenceMongodb.readByAppellation("Miguel Martinez");
        assertEquals("Miguel Martinez", tutor.getAppellation());
        assertEquals("Armful", tutor.getSpecialty());
        assertEquals(5, tutor.getExperience());
    }
}
