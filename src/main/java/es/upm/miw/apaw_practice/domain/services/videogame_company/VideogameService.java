package es.upm.miw.apaw_practice.domain.services.videogame_company;

import es.upm.miw.apaw_practice.domain.models.videogame_company.Videogame;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company.VideogamePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class VideogameService {
    private final VideogamePersistence videogamePersistence;

    @Autowired
    public VideogameService(VideogamePersistence videogamePersistence){
        this.videogamePersistence = videogamePersistence;
    }

    public void delete(String name){
        this.videogamePersistence.delete(name);
    }

    public Videogame updateReleaseDateByName(String name){
        return this.videogamePersistence.updateReleaseDateByName(name);
    }

    public BigDecimal findSumOfVideogamePricesByGameEngineLicence(String license){
        return this.videogamePersistence.readAll()
                .filter(videogame -> videogame.getGameEngine().getLicense().equals(license)
                )
                .map(Videogame::getPrice)
                .reduce((accumulatorPrice, currentPrice) -> currentPrice.add(accumulatorPrice))
                .orElse(BigDecimal.ZERO);
    }
}
