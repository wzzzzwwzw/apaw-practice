package es.upm.miw.apaw_practice.adapters.rest.olympic_games;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.olympic_games.OlympicGames;
import es.upm.miw.apaw_practice.domain.services.olympic_games.OlympicGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(OlympicGamesResource.OLYMPIC_GAMES)
public class OlympicGamesResource {
    static final String OLYMPIC_GAMES = "/olympic-games/games";
    static final String EDITION_ID = "/{edition}";
    static final String HOSTING_PLACE = "/hostingPlace";

    static final String SEARCH = "/search";
    private final OlympicGamesService olympicGamesService;

    @Autowired
    public OlympicGamesResource(OlympicGamesService olympicGamesService) {
        this.olympicGamesService = olympicGamesService;
    }

    @GetMapping(EDITION_ID)
    public OlympicGames readByEdition(@PathVariable Integer edition) {
        return this.olympicGamesService.readByEdition(edition);
    }

    @PatchMapping(EDITION_ID + HOSTING_PLACE)
    public OlympicGames updateAge(@PathVariable Integer edition, @RequestBody String hostingPlace) {
        return this.olympicGamesService.updateHostingPlace(edition, hostingPlace);
    }

    @GetMapping(SEARCH)
    public List<String> findHostingPlaceByCompetition(@RequestParam String q) {
        String competition = new LexicalAnalyzer().extractWithAssure(q, "competition");
        return this.olympicGamesService.findHostingPlaceByCompetition(competition);
    }

}
