package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy;

import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.daos.AcademyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.daos.InstructorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.daos.TournamentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities.AcademyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities.CourtEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities.InstructorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities.TournamentEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Service
public class PadelAcademySeederService {
    @Autowired
    private AcademyRepository academyRepository;
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private TournamentRepository tournamentRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("----------- Padel Academy Initial Load -----------");

        CourtEntity[] courts = {
                new CourtEntity(1, true, "clay"),
                new CourtEntity(2, true, "clay"),
                new CourtEntity(3, false, "clay"),
                new CourtEntity(4, false, "clay"),
                new CourtEntity(5, true, "grass"),
                new CourtEntity(6, true, "grass"),
                new CourtEntity(7, false, "grass"),
                new CourtEntity(8, false, "grass"),
        };

        InstructorEntity[] instructors = {
                new InstructorEntity("12345678A", "Ana", 654456545),
                new InstructorEntity("13579086B", "Pedro", 678787667),
                new InstructorEntity("64736893M", "Luis", 618273645),
                new InstructorEntity("602028404", "Lucía", 676859403),
                new InstructorEntity("02321382H", "Jaime", 632783667),
                new InstructorEntity("74938274A", "Sara", 678732217),
        };
        this.instructorRepository.saveAll(Arrays.asList(instructors));

        AcademyEntity[] academies = {
                new AcademyEntity("Ocio y Deporte Canal", "Avda. Filipinas, esq. Pablo Iglesias, 28003", "Madrid", Arrays.asList(instructors[0], instructors[2], instructors[3]), Arrays.asList(courts[0], courts[2], courts[4], courts[6] )),
                new AcademyEntity("La Masó Sports Club", "Calle de la Masó 34, 28035", "Madrid", Arrays.asList(instructors[0], instructors[1], instructors[3], instructors[4]), Arrays.asList(courts[1], courts[3], courts[5], courts[7])),
        };
        this.academyRepository.saveAll(Arrays.asList(academies));

        TournamentEntity[] tournaments = {
                new TournamentEntity("Torneo Padel Fever", new BigDecimal("100.00"),  LocalDate.of(2023, 11, 1), academies[0]),
                new TournamentEntity("Torneo Olympic Padel", new BigDecimal("70.00"),  LocalDate.of(2023, 11, 15), academies[0]),
                new TournamentEntity("Torneo Padel&Friends", new BigDecimal("5.00"),  LocalDate.of(2023, 11, 20), academies[1]),
                new TournamentEntity("Torneo SurEvents", new BigDecimal("70.00"),  LocalDate.of(2023, 12, 1), academies[1]),
        };
        this.tournamentRepository.saveAll(Arrays.asList(tournaments));
    }

    public void deleteAll() {
        this.instructorRepository.deleteAll();
        this.academyRepository.deleteAll();
        this.tournamentRepository.deleteAll();
    }
}
