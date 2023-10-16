package es.upm.miw.apaw_practice.adapters.rest.olympic_games;

import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import es.upm.miw.apaw_practice.domain.services.olympic_games.CompetitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CompetitorResource.COMPETITOR)
public class CompetitorResource {
    static final String COMPETITOR = "/olympic-games/competitors";
    private final CompetitorService competitorService;

    @Autowired
    public CompetitorResource(CompetitorService competitorService) {
        this.competitorService = competitorService;
    }

    @PostMapping
    public Competitor create(@RequestBody Competitor competitor) {
        return this.competitorService.create(competitor);
    }
}
