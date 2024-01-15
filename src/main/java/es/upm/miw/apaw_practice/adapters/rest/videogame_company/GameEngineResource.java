package es.upm.miw.apaw_practice.adapters.rest.videogame_company;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.videogame_company.GameEngine;
import es.upm.miw.apaw_practice.domain.services.videogame_company.GameEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(GameEngineResource.GAME_ENGINES)
public class GameEngineResource {
    static final String GAME_ENGINES = "/videogame-company/game-engines";
    static final String NAME_ID = "/{name}";
    static final String SEARCH = "/search";
    private final GameEngineService gameEngineService;

    @Autowired
    public GameEngineResource(GameEngineService gameEngineService){
        this.gameEngineService = gameEngineService;
    }

    @GetMapping(NAME_ID)
    public GameEngine read(@PathVariable String name){
        return this.gameEngineService.read(name);
    }

    @GetMapping(SEARCH)
    public List<String> findGameEngineNamesByCountryAndVideogameGenre(@RequestParam String q){
        String country = new LexicalAnalyzer().extractWithAssure(q, "country", String::new);
        String genre = new LexicalAnalyzer().extractWithAssure(q, "genre", String::new);
        return this.gameEngineService.findGameEngineNamesByCountryAndVideogameGenre(country,genre);
    }
}
