package es.upm.miw.apaw_practice.adapters.rest.subway;

import es.upm.miw.apaw_practice.domain.models.subway.Line;
import es.upm.miw.apaw_practice.domain.models.subway.Subway;
import es.upm.miw.apaw_practice.domain.services.subway.SubwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(SubwayResource.SUBWAYS)
public class SubwayResource {
    static final String SUBWAYS = "/subway/subways";

    static final String CITY_ID = "/{city}";

    static final String LINES = "/lines";

    static final String LABEL_ID = "/{label}";

    private final SubwayService subwayService;

    @Autowired
    public SubwayResource(SubwayService subwayService) {
        this.subwayService = subwayService;
    }


    @GetMapping(CITY_ID + LINES + LABEL_ID)
    public Line read(@PathVariable String city, @PathVariable String label) {
        return this.subwayService.findLineByCityAndLabel(city, label);
    }

    @GetMapping(CITY_ID)
    public Subway read(@PathVariable String city) {
        return this.subwayService.findByCity(city);
    }


    @PutMapping(CITY_ID + LINES)
    public Subway updateStation(@PathVariable String city, @RequestBody List<Line> lines) {
        return this.subwayService.updateLines(city, lines);
    }

}
