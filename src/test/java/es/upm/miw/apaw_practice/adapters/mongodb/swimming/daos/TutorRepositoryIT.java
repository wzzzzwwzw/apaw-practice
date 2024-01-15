package es.upm.miw.apaw_practice.adapters.mongodb.swimming.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities.TutorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class TutorRepositoryIT {

    @Autowired
    private TutorRepository tutorRepository;
    private static final String TUTOR_APPELLATION= "David Ortiz";

    @Test
    void testFindByAppellation(){
        assertTrue(this.tutorRepository.findByAppellation(TUTOR_APPELLATION).isPresent());
        TutorEntity tutor = this.tutorRepository.findByAppellation(TUTOR_APPELLATION).get();
        assertEquals(TUTOR_APPELLATION,tutor.getAppellation());
        assertEquals("Crawl",tutor.getSpecialty());
        assertEquals(7,tutor.getExperience());

        assertEquals("butterfly",tutor.getLessonEntity().getSwimStyle());
        assertEquals("Half", tutor.getLessonEntity().getSwimRange());
        assertEquals("200 meters butterfly style", tutor.getLessonEntity().getDescription());
        assertTrue(tutor.getLessonEntity().getLessonDay().isBefore(LocalDateTime.now()));
    }
}
