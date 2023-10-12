package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Painter;
import es.upm.miw.apaw_practice.domain.services.museum.PainterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PainterResource.PAINTERS)
public class PainterResource {
    static final String PAINTERS = "/museum/painters";
    static final String SURNAME_ID = "/{surname}";

    private final PainterService painterService;

    @Autowired
    public PainterResource(PainterService painterService) {
        this.painterService = painterService;
    }

    @PutMapping(SURNAME_ID)
    public Painter update(@PathVariable String surname, @RequestBody Painter painter) {
        return this.painterService.update(surname, painter);
    }
}
