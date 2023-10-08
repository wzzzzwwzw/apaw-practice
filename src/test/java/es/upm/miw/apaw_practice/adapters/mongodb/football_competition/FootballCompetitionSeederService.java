package es.upm.miw.apaw_practice.adapters.mongodb.football_competition;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos.FootballCompetitionRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos.FootballGameRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos.FootballPlayerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos.FootballTeamRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballCompetitionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballGameEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballPlayerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballTeamEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FootballCompetitionSeederService {
    @Autowired
    private FootballTeamRepository footballTeamRepository;
    @Autowired
    private FootballPlayerRepository footballPlayerRepository;
    @Autowired
    private FootballGameRepository footballGameRepository;
    @Autowired
    private FootballCompetitionRepository footballCompetitionRepository;


    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Football Competition Initial Load -----------");

        FootballTeamEntity[] footballTeams = {
                new FootballTeamEntity("Madrid", 1900, new BigDecimal("1238333.23"), false),
                new FootballTeamEntity("Barcelona", 1892, new BigDecimal("3929210.34"), false),
                new FootballTeamEntity("Valencia", 1923, new BigDecimal("5838313.23"), false),
                new FootballTeamEntity("Zaragoza", 1901, new BigDecimal("9493922.54"), false),
        };
        this.footballTeamRepository.saveAll(Arrays.asList(footballTeams));

        FootballPlayerEntity[] footballPlayers = {
                new FootballPlayerEntity("Luka Modric", new BigDecimal("129283.23"), (float)1.74, 2, 15, footballTeams[0]),
                new FootballPlayerEntity("Lionel Messi", new BigDecimal("928383.02"), (float)1.70, 25, 20, footballTeams[1]),
                new FootballPlayerEntity("David Villa", new BigDecimal("499222.54"), (float)1.78, 18, 3, footballTeams[2]),
                new FootballPlayerEntity("Javier Mascherano", new BigDecimal("329944.02"), (float)1.76, 0, 2, footballTeams[3]),
        };
        this.footballPlayerRepository.saveAll(Arrays.asList(footballPlayers));

        FootballGameEntity[] footballGames = {
                new FootballGameEntity(LocalDateTime.of(2023, 5, 1, 21, 0), "Madrid", "Mateu Lahoz"),
                new FootballGameEntity(LocalDateTime.of(2023, 5, 2, 21, 0), "Barcelona", "De Burgos Bengoetxea"),
        };
        this.footballGameRepository.saveAll(Arrays.asList(footballGames));

        FootballCompetitionEntity footballCompetition = new FootballCompetitionEntity(new BigDecimal("1000000.00"), "RFEF");
        footballCompetition.addSponsor("BBVA");
        footballCompetition.addSponsor("Nike");
        footballCompetition.setTeams(List.of(footballTeams));
        this.footballCompetitionRepository.save(footballCompetition);
    }
    public void deleteAll() {
        this.footballTeamRepository.deleteAll();
        this.footballPlayerRepository.deleteAll();
        this.footballGameRepository.deleteAll();
        this.footballCompetitionRepository.deleteAll();
    }
}
