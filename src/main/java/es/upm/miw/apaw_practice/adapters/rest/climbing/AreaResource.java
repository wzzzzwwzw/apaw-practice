package es.upm.miw.apaw_practice.adapters.rest.climbing;

import es.upm.miw.apaw_practice.domain.models.climbing.Area;
import es.upm.miw.apaw_practice.domain.models.climbing.Climber;
import es.upm.miw.apaw_practice.domain.services.climbing.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AreaResource.AREAS)
public class AreaResource {

    static final String AREAS = "/climbing/areas";
    static final String NAME_ID = "/{name}";

    private final AreaService areaService;

    @Autowired
    public AreaResource(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping(NAME_ID)
    public Area read(@PathVariable String name) {
        return Area.ofAreaName(this.areaService.read(name));
    }

}
