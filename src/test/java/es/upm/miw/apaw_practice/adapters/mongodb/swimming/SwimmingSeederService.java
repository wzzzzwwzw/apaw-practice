package es.upm.miw.apaw_practice.adapters.mongodb.swimming;

import es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities.InscriptionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities.LessonEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class SwimmingSeederService {

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Swimming Initial Load -----------");

        InscriptionEntity[] inscriptions = {
                new InscriptionEntity("1234", LocalDateTime.now(), true),
                new InscriptionEntity("2345", LocalDateTime.now(), false),
                new InscriptionEntity("3456", LocalDateTime.now(), true)
        };

        LessonEntity[] Lessons = {
                new LessonEntity("Brazada", "Iniciacion", "100 metros estilo brazada", LocalDateTime.now(), Arrays.asList(inscriptions[0], inscriptions[1])),
                new LessonEntity("Brazada", "Iniciacion", "100 metros estilo brazada", LocalDateTime.now(), Arrays.asList(inscriptions[1], inscriptions[2])),
                new LessonEntity("Crol", "Medio", "200 metros estilo crol", LocalDateTime.now(), Arrays.asList(inscriptions[2], inscriptions[3]))
        };


    }
}
