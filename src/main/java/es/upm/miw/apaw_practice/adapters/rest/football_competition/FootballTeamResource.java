package es.upm.miw.apaw_practice.adapters.rest.football_competition;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballTeam;
import es.upm.miw.apaw_practice.domain.services.football_competition.FootballTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FootballTeamResource.TEAMS)
public class FootballTeamResource {
    static final String TEAMS = "/football_competition/teams";
    static final String CITY_ID = "/{city}";
    private final FootballTeamService footballTeamService;

    @Autowired
    public FootballTeamResource(FootballTeamService footballTeamService) {
        this.footballTeamService = footballTeamService;
    }

    @GetMapping(CITY_ID)
    public FootballTeam read(@PathVariable String city) {
        return this.footballTeamService.read(city);
    }
}
