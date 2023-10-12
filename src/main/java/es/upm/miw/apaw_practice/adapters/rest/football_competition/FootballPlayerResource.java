package es.upm.miw.apaw_practice.adapters.rest.football_competition;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballPlayer;
import es.upm.miw.apaw_practice.domain.services.football_competition.FootballPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(FootballPlayerResource.PLAYERS)
public class FootballPlayerResource {
    static final String PLAYERS = "/football_competition/players";
    static final String NAME_ID = "/{name}";
    static final String GOALS = "/goals";
    private final FootballPlayerService footballPlayerService;

    @Autowired
    public FootballPlayerResource(FootballPlayerService footballPlayerService) {
        this.footballPlayerService = footballPlayerService;
    }

    @PutMapping(NAME_ID + GOALS)
    public FootballPlayer updateGoals(@PathVariable String name, @RequestBody Integer goals) {
        return this.footballPlayerService.updateGoals(name, goals);
    }
}
