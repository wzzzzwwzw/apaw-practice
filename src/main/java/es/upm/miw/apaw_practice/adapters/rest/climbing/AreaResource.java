package es.upm.miw.apaw_practice.adapters.rest.climbing;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.climbing.Area;
import es.upm.miw.apaw_practice.domain.models.climbing.Route;
import es.upm.miw.apaw_practice.domain.services.climbing.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AreaResource.AREAS)
public class AreaResource {

    static final String AREAS = "/climbing/areas";
    static final String NAME_ID = "/{name}";
    static final String ROUTES = "/routes";
    static final String KEY_ID = "/{key}";
    static final String SEARCH = "/search";

    private final AreaService areaService;

    @Autowired
    public AreaResource(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping(NAME_ID)
    public Area read(@PathVariable String name) {
        return this.areaService.read(name);
    }

    @PutMapping(NAME_ID + ROUTES + KEY_ID)
    public Area updateRoute(@PathVariable String name, @PathVariable String key, @RequestBody Route route) {
        return this.areaService.updateRoute(name, key, route);
    }

    @GetMapping(SEARCH)
    public String[] findRouteNamesByClimberLevel(@RequestParam String q) {
        String level = new LexicalAnalyzer().extractWithAssure(q, "level");
        return this.areaService.findRouteNamesByClimberLevel(level);
    }
}
