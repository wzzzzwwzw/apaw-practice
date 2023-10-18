package es.upm.miw.apaw_practice.adapters.mongodb.swimming;

import es.upm.miw.apaw_practice.adapters.mongodb.swimming.daos.ApprenticeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.swimming.daos.LessonRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.swimming.daos.TutorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities.ApprenticeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities.InscriptionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities.LessonEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities.TutorEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

@Service
public class SwimmingSeederService {

    @Autowired
    private ApprenticeRepository apprenticeRepository;
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private TutorRepository tutorRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Swimming Initial Load -----------");

        InscriptionEntity[] inscriptions = {
                new InscriptionEntity(LocalDateTime.now(), true),
                new InscriptionEntity(LocalDateTime.now(), false),
                new InscriptionEntity(LocalDateTime.now(), true),
                new InscriptionEntity(LocalDateTime.now(), false)
        };

        ApprenticeEntity[] apprentices = {
                new ApprenticeEntity("Jose David Velasquez", 32, "Colmerauer Viejo", Arrays.asList(inscriptions[1], inscriptions[3])),
                new ApprenticeEntity("Maximilian Ramos", 2, "Madrid",Collections.singletonList(inscriptions[0])),
                new ApprenticeEntity("Carolina Vasquez", 30, "Barcelona", Collections.singletonList(inscriptions[2])),
        };
        this.apprenticeRepository.saveAll(Arrays.asList(apprentices));

        LessonEntity[] lessons = {
                new LessonEntity("Armful", "Initiation", "100 meters armful style", LocalDateTime.now(), Arrays.asList(inscriptions[0], inscriptions[2])),
                new LessonEntity("butterfly", "Half", "200 meters butterfly style", LocalDateTime.now(), Collections.singletonList(inscriptions[1])),
                new LessonEntity("Crawl", "Half", "200 meters crawl style", LocalDateTime.now(), Collections.singletonList(inscriptions[3]))
        };
        this.lessonRepository.saveAll(Arrays.asList(lessons));

        TutorEntity[] tutors = {
                new TutorEntity("Miguel Martinez","Armful",5,lessons[0]),
                new TutorEntity("David Ortiz","Crawl",7,lessons[1]),
                new TutorEntity("Daniel Rodriguez","butterfly",9,lessons[2]),
                new TutorEntity("Ronald Bate","Crawl",1,lessons[0])
        };
        this.tutorRepository.saveAll(Arrays.asList(tutors));
    }

    public void deleteAll() {
        this.apprenticeRepository.deleteAll();
        this.lessonRepository.deleteAll();
        this.tutorRepository.deleteAll();
    }
}
