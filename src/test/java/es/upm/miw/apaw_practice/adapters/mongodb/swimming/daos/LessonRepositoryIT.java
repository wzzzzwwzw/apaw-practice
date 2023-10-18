package es.upm.miw.apaw_practice.adapters.mongodb.swimming.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities.LessonEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class LessonRepositoryIT {

    @Autowired
    private LessonRepository lessonRepository;
    private static final String SWIMMING_STYLE = "Armful";
    private static final String SWIMMING_RANGE = "Initiation";

    @Test
    void testFindBySwimStyleAndSwimRange() {
        assertTrue(this.lessonRepository.findBySwimStyleAndSwimRange(SWIMMING_STYLE,SWIMMING_RANGE).isPresent());
        LessonEntity lesson = this.lessonRepository.findBySwimStyleAndSwimRange(SWIMMING_STYLE,SWIMMING_RANGE).get();
        assertEquals(SWIMMING_STYLE, lesson.getSwimStyle());
        assertEquals(SWIMMING_RANGE, lesson.getSwimRange());
        assertEquals("100 meters armful style", lesson.getDescription());
        assertTrue(lesson.getLessonDay().isBefore(LocalDateTime.now()));
        assertEquals(2,lesson.getInscriptionEntities().size());

        assertTrue(lesson.getInscriptionEntities().stream()
                .anyMatch( inscription ->
                        inscription.getRecordDate().isBefore(LocalDateTime.now()) &&
                                inscription.getAsset()
                ));
    }
}
