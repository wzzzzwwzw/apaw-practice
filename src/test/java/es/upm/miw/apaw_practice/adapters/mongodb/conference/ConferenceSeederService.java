package es.upm.miw.apaw_practice.adapters.mongodb.conference;

import es.upm.miw.apaw_practice.adapters.mongodb.conference.daos.AuthorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.daos.ConferenceLocationRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.daos.ConferenceRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.daos.PaperRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.entities.AuthorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.entities.ConferenceEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.entities.ConferenceLocationEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.entities.PaperEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class ConferenceSeederService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ConferenceRepository conferenceRepository;
    @Autowired
    private ConferenceLocationRepository conferenceLocationRepository;
    @Autowired
    private PaperRepository paperRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("---------- Conference data initial load ----------");
        ConferenceLocationEntity[] conferenceLocations = {
                new ConferenceLocationEntity("Toulouse", "Mercure Toulouse Centre Compans", "Main hall"),
                new ConferenceLocationEntity("Florence", "Meyer Health Campus", "Main hall"),
                new ConferenceLocationEntity("San Antonio", "The University of Texas at San Antonio", "Student Union")
        };
        this.conferenceLocationRepository.saveAll(Arrays.asList(conferenceLocations));

        AuthorEntity[] authors = {
                new AuthorEntity("Jorge", "Da Silva", "Mr."),
                new AuthorEntity("Miren", "Illarramendi", "Ms."),
                new AuthorEntity("Aitor", "Arrieta", "Dr."),
                new AuthorEntity("Wil", "van der Aalst", "Professor"),
                new AuthorEntity("Igor", "López", "Mr."),
                new AuthorEntity("Gaizka", "Bellido", "Mr.")
        };
        this.authorRepository.saveAll(Arrays.asList(authors));

        PaperEntity[] papers = {
                new PaperEntity("Paper 1", "DOI 1", 10, List.of(authors[0], authors[1])),
                new PaperEntity("Paper 2", "DOI 2", 5, List.of(authors[0], authors[1], authors[2])),
                new PaperEntity("Paper 3", "DOI 3", 8, List.of(authors[3])),
                new PaperEntity("Paper 4", "DOI 4", 7, List.of(authors[0], authors[1], authors[2], authors[4], authors[5])),
                new PaperEntity("Paper 5", "DOI 5", 14, List.of(authors[3], authors[5])),
                new PaperEntity("Paper 6", "DOI 6", 3, List.of(authors[5]))
        };
        this.paperRepository.saveAll(Arrays.asList(papers));

        ConferenceEntity[] conferences = {
                new ConferenceEntity(LocalDateTime.now(), true, "Security", conferenceLocations[0], List.of(papers[0], papers[1], papers[5])),
                new ConferenceEntity(LocalDateTime.now().minusDays(30), false, "DevOps", conferenceLocations[1], List.of(papers[2])),
                new ConferenceEntity(LocalDateTime.now().plusYears(3), true, "DevOps", conferenceLocations[2], List.of(papers[3], papers[4]))
        };
        this.conferenceRepository.saveAll(Arrays.asList(conferences));
    }

    public void deleteAll() {
        this.authorRepository.deleteAll();
        this.conferenceLocationRepository.deleteAll();
        this.conferenceRepository.deleteAll();
        this.paperRepository.deleteAll();
    }
}
