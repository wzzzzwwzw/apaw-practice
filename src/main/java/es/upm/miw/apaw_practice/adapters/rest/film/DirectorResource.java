package es.upm.miw.apaw_practice.adapters.rest.film;

import es.upm.miw.apaw_practice.domain.models.film.Director;
import es.upm.miw.apaw_practice.domain.services.film.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DirectorResource.DIRECTORS)
public class DirectorResource {
    static final String DIRECTORS = "/film/directors";

    static final String DNI_ID = "/{dni}";

    private final DirectorService directorService;

    @Autowired
    public DirectorResource(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PostMapping
    public Director create(@RequestBody Director director) {
        return this.directorService.create(director);
    }

    @PatchMapping(DNI_ID)
    public Director updateSurname(@PathVariable String dni, @RequestBody String surname) {
        return this.directorService.updateSurname(dni, surname);
    }

}
