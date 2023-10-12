package es.upm.miw.apaw_practice.adapters.rest.olympic_games;

import es.upm.miw.apaw_practice.domain.models.olympic_games.OlympicGames;
import es.upm.miw.apaw_practice.domain.services.olympic_games.OlympicGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(OlympicGamesResource.OLYMPIC_GAMES)
public class OlympicGamesResource {
    static final String OLYMPIC_GAMES = "/olympic-games/games";
    static final  String EDITION_ID = "/{edition}";
    private final OlympicGamesService olympicGamesService;

    @Autowired
    public OlympicGamesResource(OlympicGamesService olympicGamesService) {
        this.olympicGamesService = olympicGamesService;
    }

    @GetMapping(EDITION_ID)
    public OlympicGames readByEdition(@PathVariable Integer edition) {
        return this.olympicGamesService.readByEdition(edition);
    }

}
