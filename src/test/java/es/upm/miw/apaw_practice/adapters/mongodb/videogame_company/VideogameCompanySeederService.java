package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos.FeatureRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos.GameEngineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos.VideogameCompanyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos.VideogameRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities.FeatureEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities.GameEngineEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities.VideogameCompanyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities.VideogameEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

@Service
public class VideogameCompanySeederService{
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private GameEngineRepository gameEngineRepository;
    @Autowired
    private VideogameRepository videogameRepository;
    @Autowired
    private VideogameCompanyRepository videogameCompanyRepository;

    public void seedDatabase(){
        LogManager.getLogger(this.getClass()).warn("-----Videogame Company Initial Data Load -----");
        GameEngineEntity[] gameEngines = {
                new GameEngineEntity("Unity","C#","Freemium"),
                new GameEngineEntity("RPG Maker", "Javascript", "Paid"),
                new GameEngineEntity("Unreal Engine","C++","Freemium"),
                new GameEngineEntity("MonoGame", "C#","Free"),
        };
        gameEngineRepository.saveAll(Arrays.asList(gameEngines));

        FeatureEntity[] features = {
                new FeatureEntity("RPG","Turn Based",true),
                new FeatureEntity("Action","Turn Based", false),
                new FeatureEntity("Survival", "Puzzle",true),
                new FeatureEntity("Strategy", "Real Time", false),
                new FeatureEntity("Visual Novel", "Point and Click", true),
        };
        featureRepository.saveAll(Arrays.asList(features));

        VideogameEntity[] videogames = {
                new VideogameEntity("Super Bomberman R", new BigDecimal("39.99"),
                        LocalDate.of(2017,3,3),gameEngines[0],
                        Arrays.asList(features[1],features[3])),//konami
                new VideogameEntity("Shin Megami Tensei V",new BigDecimal("59.99"),
                        LocalDate.of(2011,11,11),gameEngines[2],
                        Arrays.asList(features[0],features[1],features[4])),//atlus
                new VideogameEntity("Dragon Quest 11",new BigDecimal("69.99"),
                        LocalDate.of(2017,7,29),gameEngines[2],
                        Arrays.asList(features[0],features[4])),//square enix
                new VideogameEntity("Deus Ex Go",new BigDecimal("6.99"),
                        LocalDate.of(2016,8,18),gameEngines[0],
                        Arrays.asList(features[3],features[4])),//square enix
                new VideogameEntity("Silent Hill 2",new BigDecimal("59.99"),
                        LocalDate.of(2016,8,18),gameEngines[2],
                        Collections.singletonList(features[2])),//konami
                new VideogameEntity("Bastion",new BigDecimal("14.79"),
                        LocalDate.of(2011,8,16),gameEngines[3],
                        Arrays.asList(features[2],features[3])),//supergiant games
                new VideogameEntity("Pyre",new BigDecimal("19.50"),
                        LocalDate.of(2017,7,25),gameEngines[3],
                        Collections.singletonList(features[0])),//supergiant games
                new VideogameEntity("To the Moon",new BigDecimal("9.75"),
                        LocalDate.of(2011,11,1),gameEngines[1],
                        Arrays.asList(features[1],features[4])),//freebird games
        };
        videogameRepository.saveAll(Arrays.asList(videogames));

        VideogameCompanyEntity[] videogameCompanies = {
                new VideogameCompanyEntity("Konami","Japan",
                        LocalDate.of(1969,3,21),Arrays.asList(videogames[0],videogames[4])),
                new VideogameCompanyEntity("Atlus","Japan",
                        LocalDate.of(1986,4,7),Collections.singletonList(videogames[1])),
                new VideogameCompanyEntity("Square Enix","Japan",
                        LocalDate.of(2003,4,1),Arrays.asList(videogames[2],videogames[3])),
                new VideogameCompanyEntity("Supergiant Games","United States",
                        LocalDate.of(2009,1,1),Arrays.asList(videogames[5],videogames[6])),
                new VideogameCompanyEntity("Freebird Games","United States",
                        LocalDate.of(2007,1,1),Collections.singletonList(videogames[7])),

        };
        videogameCompanyRepository.saveAll(Arrays.asList(videogameCompanies));
    }

    public void deleteAll() {
        this.gameEngineRepository.deleteAll();
        this.featureRepository.deleteAll();
        this.videogameRepository.deleteAll();
        this.videogameCompanyRepository.deleteAll();
    }
}
