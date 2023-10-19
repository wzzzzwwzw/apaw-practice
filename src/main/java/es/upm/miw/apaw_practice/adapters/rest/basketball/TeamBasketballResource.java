package es.upm.miw.apaw_practice.adapters.rest.basketball;
import es.upm.miw.apaw_practice.domain.models.basketball.Team;
import es.upm.miw.apaw_practice.domain.services.basketball.TeamBasketballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(TeamBasketballResource.TEAMSBASKETBALL)
public class TeamBasketballResource {
    static final String TEAMSBASKETBALL = "/basketball/teams";

    static final String ALIAS_ID = "/{alias}";

    private final TeamBasketballService teamBasketballService;

    @Autowired
    public TeamBasketballResource(TeamBasketballService teamBasketballService) {
        this.teamBasketballService = teamBasketballService;
    }

    @GetMapping(ALIAS_ID)
    public Team read(@PathVariable String alias) {
        return this.teamBasketballService.read(alias);
    }
}