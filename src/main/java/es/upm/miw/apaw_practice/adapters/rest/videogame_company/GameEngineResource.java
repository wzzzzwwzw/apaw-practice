package es.upm.miw.apaw_practice.adapters.rest.videogame_company;

import es.upm.miw.apaw_practice.domain.models.videogame_company.GameEngine;
import es.upm.miw.apaw_practice.domain.services.videogame_company.GameEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GameEngineResource.GAME_ENGINES)
public class GameEngineResource {
    static final String GAME_ENGINES = "/videogame-company/game-engines";
    static final String NAME_ID = "/{name}";
    private final GameEngineService gameEngineService;

    @Autowired
    public GameEngineResource(GameEngineService gameEngineService){
        this.gameEngineService = gameEngineService;
    }

    @GetMapping(NAME_ID)
    public GameEngine read(@PathVariable String name){
        return this.gameEngineService.read(name);
    }
}
