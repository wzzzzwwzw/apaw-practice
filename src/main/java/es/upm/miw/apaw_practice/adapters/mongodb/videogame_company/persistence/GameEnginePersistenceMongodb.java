package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos.GameEngineRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.videogame_company.GameEngine;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company.GameEnginePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("gameEnginePersistence")
public class GameEnginePersistenceMongodb implements GameEnginePersistence {
    private final GameEngineRepository gameEngineRepository;

    @Autowired
    public  GameEnginePersistenceMongodb(GameEngineRepository gameEngineRepository){
        this.gameEngineRepository = gameEngineRepository;
    }

    @Override
    public GameEngine read(String name){
        return this.gameEngineRepository
                .findByName(name)
                .orElseThrow(()-> new NotFoundException("Game Engine name: " + name))
                .toGameEngine();
    }

}
