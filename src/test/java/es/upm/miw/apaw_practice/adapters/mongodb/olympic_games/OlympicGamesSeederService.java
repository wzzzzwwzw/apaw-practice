package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games;

import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos.CompetitorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos.DisciplineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos.MedalRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos.OlympicGamesRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.CompetitorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.DisciplineEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.MedalEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.OlympicGamesEntity;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class OlympicGamesSeederService {

    @Autowired
    private OlympicGamesRepository olympicGamesRepository;
    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private CompetitorRepository competitorRepository;
    @Autowired
    private MedalRepository medalRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Olympic Games Initial Load -----------");
        CompetitorEntity[] competitors = {
                new CompetitorEntity(new Competitor("Fernando", "Spain", 40)),
                new CompetitorEntity(new Competitor("Vini", "Brazil", 24)),
                new CompetitorEntity(new Competitor("Luka", "Slovakia", 23)),
                new CompetitorEntity(new Competitor("Mel", "United States", 25)),
                new CompetitorEntity(new Competitor("Cristina", "Spain", 19)),
                new CompetitorEntity(new Competitor("Marco", "Italy", 24)),
                new CompetitorEntity(new Competitor("Gilbert", "France", 27)),
                new CompetitorEntity(new Competitor("Lebron", "United States", 36))
        };
        this.competitorRepository.saveAll(Arrays.asList(competitors));
        MedalEntity[] medals = {
                new MedalEntity("Gold", true, "Basketball", competitors[7]),
                new MedalEntity("Silver", false, "Fencing", competitors[3]),
                new MedalEntity("Gold", false, "Badminton", competitors[6]),
                new MedalEntity("Bronze", true, "4x100m relays", competitors[4]),
                new MedalEntity("Bronze", true, "4x100m relays", competitors[0]),
                new MedalEntity("Gold", false, "Judo", competitors[5])
        };
        this.medalRepository.saveAll(Arrays.asList(medals));
        DisciplineEntity[] disciplines = {
                new DisciplineEntity("Athletics", 47, LocalDate.of(1896, 3, 10), List.of(competitors[0], competitors[4])),
                new DisciplineEntity("Basketball", 2, LocalDate.of(1936, 3, 10), List.of(competitors[7])),
                new DisciplineEntity("Fencing", 10, LocalDate.of(1896, 5, 10), List.of(competitors[3])),
                new DisciplineEntity("Judo", 14, LocalDate.of(1964, 4, 10), List.of(competitors[5]))
        };
        this.disciplineRepository.saveAll(Arrays.asList(disciplines));
        OlympicGamesEntity[] olympicGames = {
                new OlympicGamesEntity(1,"Athens", LocalDate.of(1896,4,5), true, List.of(disciplines[0], disciplines[2])),
                new OlympicGamesEntity(14,"London", LocalDate.of(1948,7,29), true, List.of(disciplines[0], disciplines[1], disciplines[2])),
                new OlympicGamesEntity(25,"Barcelona", LocalDate.of(1992,7,25), true, List.of(disciplines[0], disciplines[1], disciplines[2], disciplines[3]))
        };
        this.olympicGamesRepository.saveAll(Arrays.asList(olympicGames));
    }
    public void deleteAll() {
        this.competitorRepository.deleteAll();
        this.medalRepository.deleteAll();
        this.disciplineRepository.deleteAll();
        this.olympicGamesRepository.deleteAll();
    }

    public void reSeedDatabase() {
        this.deleteAll();
        this.seedDatabase();
    }
}
