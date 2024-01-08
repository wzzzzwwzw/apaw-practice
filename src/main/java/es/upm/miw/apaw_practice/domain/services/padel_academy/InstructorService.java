package es.upm.miw.apaw_practice.domain.services.padel_academy;

import es.upm.miw.apaw_practice.domain.models.padel_academy.Instructor;
import es.upm.miw.apaw_practice.domain.persistence_ports.padel_academy.InstructorPersistence;
import org.springframework.beans.factory.annotation.Autowired;

public class InstructorService {
    private final InstructorPersistence instructorPersistence;

    @Autowired
    public InstructorService(InstructorPersistence instructorPersistence) {
        this.instructorPersistence = instructorPersistence;
    }
    public Instructor updatePhoneNumber(String dni, Integer phoneNumber) {
        Instructor instructor = this.instructorPersistence.read(dni);
        instructor.setPhoneNumber(phoneNumber);
        return  this.instructorPersistence.update(instructor);
    }
}
