package es.upm.miw.apaw_practice.adapters.rest.football_competition;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballGame;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballGameDateUpdating;
import es.upm.miw.apaw_practice.domain.services.football_competition.FootballGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(FootballGameResource.GAMES)
public class FootballGameResource {
    static final String GAMES = "/football_competition/games";
    private final FootballGameService footballGameService;

    @Autowired
    public FootballGameResource(FootballGameService footballGameService) {
        this.footballGameService = footballGameService;
    }

    @PatchMapping
    public List<FootballGame> patch(@RequestBody List<FootballGameDateUpdating> footballGameDateUpdatingList) {
        return this.footballGameService.updateDates(footballGameDateUpdatingList);
    }
}
