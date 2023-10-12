package es.upm.miw.apaw_practice.domain.services.videogame_company;

import es.upm.miw.apaw_practice.domain.models.videogame_company.GameEngine;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company.GameEnginePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameEngineService {
    private final GameEnginePersistence gameEnginePersistence;

    @Autowired
    public GameEngineService(GameEnginePersistence gameEnginePersistence){
        this.gameEnginePersistence = gameEnginePersistence;
    }

    public GameEngine read(String name){
        return this.gameEnginePersistence.read(name);
    }
}
