package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Player;
import es.upm.miw.apaw_practice.domain.models.basketball.Team;
import es.upm.miw.apaw_practice.domain.services.basketball.TeamBasketballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(TeamBasketballResource.TEAMSBASKETBALL)
public class TeamBasketballResource {
    static final String TEAMSBASKETBALL = "/basketball/teams";

    static final String ALIAS_ID = "/{alias}";
    static final String PLAYERS = "/players";
    static final String PLAYER_EMAIL = "/{email}";


    private final TeamBasketballService teamBasketballService;

    @Autowired
    public TeamBasketballResource(TeamBasketballService teamBasketballService) {
        this.teamBasketballService = teamBasketballService;
    }

    @PutMapping(ALIAS_ID + PLAYERS + PLAYER_EMAIL)
    public Team updatePlayer(@PathVariable String alias, @PathVariable String email, @RequestBody Player player) {
        return this.teamBasketballService.updatePlayer(alias, email, player);
    }

    @GetMapping(ALIAS_ID)
    public Team read(@PathVariable String alias) {
        return this.teamBasketballService.read(alias);
    }
}