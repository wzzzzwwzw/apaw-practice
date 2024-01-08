package es.upm.miw.apaw_practice.adapters.rest.padel_academy;

import es.upm.miw.apaw_practice.domain.models.padel_academy.Instructor;
import es.upm.miw.apaw_practice.domain.services.padel_academy.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class InstructorResource {
    static final String INSTRUCTORS = "/padel-academy/instructors";
    static final String DNI = "/{dni}";
    private final InstructorService instructorService;

    @Autowired
    public InstructorResource(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PatchMapping(DNI)
    public Instructor updatePhoneNumber(@PathVariable String dni, @RequestBody Integer phoneNumber) {
        return this.instructorService.updatePhoneNumber(dni, phoneNumber);
    }

}
