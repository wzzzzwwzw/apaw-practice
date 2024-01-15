package es.upm.miw.apaw_practice.adapters.rest.olympic_games;

import es.upm.miw.apaw_practice.domain.services.olympic_games.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DisciplineResource.DISCIPLINE)
public class DisciplineResource {
    static final  String DISCIPLINE ="/olympic-games/disciplines";
    static final String NAME_ID = "/{name}";
    private final DisciplineService disciplineService;

    @Autowired
    public DisciplineResource(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @DeleteMapping(NAME_ID)
    public void delete(@PathVariable String name) {
        this.disciplineService.delete(name);
    }
}
