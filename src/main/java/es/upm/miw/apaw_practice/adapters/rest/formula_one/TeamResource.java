package es.upm.miw.apaw_practice.adapters.rest.formula_one;

import es.upm.miw.apaw_practice.domain.services.formula_one.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TeamResource.TEAMS)
public class TeamResource {

    static final String TEAMS = "/formula-one/teams";
    static final String TEAM_NAME_ID = "/{teamName}";

    private final TeamService teamService;

    @Autowired
    public TeamResource(TeamService teamService) {
        this.teamService = teamService;
    }

    @DeleteMapping(TEAM_NAME_ID)
    public void delete(@PathVariable String teamName) {
        this.teamService.delete(teamName);
    }
}
