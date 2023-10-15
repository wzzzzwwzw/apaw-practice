package es.upm.miw.apaw_practice.adapters.rest.football_competition;

import es.upm.miw.apaw_practice.domain.services.football_competition.FootballCompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(FootballCompetitionResource.COMPETITIONS)
public class FootballCompetitionResource {
    static final String COMPETITIONS = "/football_competition/competitions";
    static final String ORGANIZING_ENTITY_ID = "/{organizingEntity}";
    private final FootballCompetitionService footballCompetitionService;

    @Autowired
    public FootballCompetitionResource(FootballCompetitionService footballCompetitionService) {
        this.footballCompetitionService = footballCompetitionService;
    }

    @DeleteMapping(ORGANIZING_ENTITY_ID)
    public void delete(@PathVariable String organizingEntity) {
        this.footballCompetitionService.delete(organizingEntity);
    }
}
