package es.upm.miw.apaw_practice.domain.models.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubjectIT {

    @Test
    void testSubjectBuilder() {
        Subject subject = Subject.builder()
            .title("newSubject")
            .description("description")
            .bilingual(true)
            .credits(50).build();
        assertNotNull(subject);
        assertEquals("newSubject", subject.getTitle());
        assertEquals("description", subject.getDescription());
        assertEquals(50, subject.getCredits());
        assertTrue(subject.getBilingual());
    }
}
