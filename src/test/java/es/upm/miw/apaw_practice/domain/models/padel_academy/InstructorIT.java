package es.upm.miw.apaw_practice.domain.models.padel_academy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InstructorIT {
    @Test
    void testBuilder() {
        Instructor instructor = Instructor.builder()
                .dni("12345678A")
                .name("Test")
                .phoneNumber(123456789)
                .build();

        Assertions.assertEquals("12345678A", instructor.getDni());
        Assertions.assertEquals("Test", instructor.getName());
        Assertions.assertEquals(123456789, instructor.getPhoneNumber());
    }
}
