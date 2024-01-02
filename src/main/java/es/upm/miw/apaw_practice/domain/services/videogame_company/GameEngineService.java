package es.upm.miw.apaw_practice.domain.services.videogame_company;

import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.videogame_company.GameEngine;
import es.upm.miw.apaw_practice.domain.models.videogame_company.Videogame;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company.GameEnginePersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company.VideogameCompanyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class GameEngineService {
    private final GameEnginePersistence gameEnginePersistence;
    private final VideogameCompanyPersistence videogameCompanyPersistence;

    @Autowired
    public GameEngineService(GameEnginePersistence gameEnginePersistence, VideogameCompanyPersistence videogameCompanyPersistence){
        this.gameEnginePersistence = gameEnginePersistence;
        this.videogameCompanyPersistence = videogameCompanyPersistence;
    }

    public GameEngine read(String name){
        return this.gameEnginePersistence.read(name);
    }

    public List<String> findGameEngineNamesByCountryAndVideogameGenre(String country, String genre){
        List<Videogame> videogameList = this.videogameCompanyPersistence.findVideogamesByCompanyCountry(country);
        if(videogameList.isEmpty()){
            throw new NotFoundException(MessageFormat.format("No game engines found for country: {0}",country));
        }
        return
                videogameList.stream()
                        .filter(videogame ->
                            videogame.getFeatures()
                                    .stream()
                                    .anyMatch(feature -> feature.getGenre().equals(genre))
                        )
                        .map(Videogame::getGameEngine)
                        .map(GameEngine::getName)
                        .distinct()
                        .toList();
    }
}
