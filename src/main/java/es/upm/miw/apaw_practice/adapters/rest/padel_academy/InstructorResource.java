package es.upm.miw.apaw_practice.adapters.rest.padel_academy;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Instructor;
import es.upm.miw.apaw_practice.domain.services.padel_academy.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(InstructorResource.INSTRUCTORS)
public class InstructorResource {
    static final String INSTRUCTORS = "/padel-academy/instructors";
    static final String DNI = "/{dni}";
    static final String SEARCH = "/search";

    private final InstructorService instructorService;

    @Autowired
    public InstructorResource(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PatchMapping(DNI)
    public Instructor updatePhoneNumber(@PathVariable String dni, @RequestBody Integer phoneNumber) {
        return this.instructorService.updatePhoneNumber(dni, phoneNumber);
    }

    @GetMapping(SEARCH)
    public List<String> findInstructorsNamesByCourtSurface(@RequestParam String q) {
        String surface = new LexicalAnalyzer().extractWithAssure(q, "surface", String::new);
        return this.instructorService.findInstructorsNamesByCourtSurface(surface);
    }
}
