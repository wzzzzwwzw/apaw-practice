package es.upm.miw.apaw_practice.adapters.mongodb.basketball;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.BasketRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.PavilionRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.PlayerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.TeamBasketballRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.BasketEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.PavilionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.PlayerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.TeamEntity;
import es.upm.miw.apaw_practice.domain.models.basketball.Pavilion;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Service
public class BasketballSeederService {

    @Autowired
    private PavilionRepository pavilionRepository;
    @Autowired
    private TeamBasketballRepository teamBasketballRepository;
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private PlayerRepository playerRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Basketball Initial Load -----------");

        PavilionEntity[] pavilions = {
                new PavilionEntity(new Pavilion("pavilion1", "direction1", 1000)),
                new PavilionEntity(new Pavilion("pavilion2", "direction2", 2000))
        };
        this.pavilionRepository.saveAll(Arrays.asList(pavilions));


        PlayerEntity[] players = {
                new PlayerEntity("email1@gmail.com", "alero" , 19),
                new PlayerEntity("email2@gmail.com", "base" , 20),
                new PlayerEntity("email3@gmail.com", "pivot" , 21)
        };
        this.playerRepository.saveAll(Arrays.asList(players));

        TeamEntity[] teams = {
                new TeamEntity("alias1", 2, "Alberto", List.of(pavilions[0], pavilions[1]), List.of(players[0], players[1])),
                new TeamEntity("alias2", 1, "Juan", List.of(pavilions[1]), List.of(players[2]))
        };
        this.teamBasketballRepository.saveAll(Arrays.asList(teams));

        BasketEntity[] baskets = {
            new BasketEntity(3, LocalDateTime.of(2023, Month.OCTOBER, 16, 16, 0), players[0]),
            new BasketEntity(2, LocalDateTime.of(2023, Month.OCTOBER, 16, 15, 0), players[1]),
        };
        this.basketRepository.saveAll(Arrays.asList(baskets));
    }

    public void deleteAll() {
        this.teamBasketballRepository.deleteAll();
        this.basketRepository.deleteAll();
        this.playerRepository.deleteAll();
        this.pavilionRepository.deleteAll();
    }
}
