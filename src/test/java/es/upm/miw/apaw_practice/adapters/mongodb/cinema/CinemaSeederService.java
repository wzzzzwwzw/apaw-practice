package es.upm.miw.apaw_practice.adapters.mongodb.cinema;

import es.upm.miw.apaw_practice.adapters.mongodb.cinema.daos.FilmRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.cinema.daos.ScreenRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.cinema.daos.SpectatorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.cinema.entities.ActorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.cinema.entities.FilmEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.cinema.entities.ScreenEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.cinema.entities.SpectatorEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CinemaSeederService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private SpectatorRepository spectatorRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Cinema Initial Load -----------");
        ActorEntity[] actors = {
                new ActorEntity("Jennifer", "Lawrence", 31),
                new ActorEntity("Josh", "Hutcherson", 28),
                new ActorEntity("Woody", "Harrelson", 60),
                new ActorEntity("Liam", "Hemsworth", 31)
        };
        SpectatorEntity[] spectators = {
                new SpectatorEntity("12345j", "Tomas", "Smith"),
                new SpectatorEntity("98745p", "John", "Gomez"),
                new SpectatorEntity("98745p", "Mary", "Banks"),
                new SpectatorEntity("98745p", "Zoe", "Alley")
        };
        this.spectatorRepository.saveAll(Arrays.asList(spectators));
        ScreenEntity[] screens = {
                new ScreenEntity(1,1,70,false, List.of(spectators[0], spectators[1], spectators[2])),
                new ScreenEntity(2,1,70,false, List.of(spectators[3]))
        };
        this.screenRepository.saveAll(Arrays.asList(screens));
        FilmEntity[] films = {
                new FilmEntity("7890", "The hunger games", "Katniss Everdeen voluntarily takes her younger sister's place in the Hunger Games", List.of(actors[0], actors[1], actors[2], actors[3]), List.of(screens[0], screens[1]))
        };
        this.filmRepository.saveAll(Arrays.asList(films));
    }

    public void deleteAll() {
        this.filmRepository.deleteAll();
        this.spectatorRepository.deleteAll();
        this.screenRepository.deleteAll();
    }
}
