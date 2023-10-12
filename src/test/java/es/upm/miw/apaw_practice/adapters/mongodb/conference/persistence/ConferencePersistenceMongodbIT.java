package es.upm.miw.apaw_practice.adapters.mongodb.conference.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.conference.Conference;
import es.upm.miw.apaw_practice.domain.models.conference.ConferenceLocation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;
@TestConfig
class ConferencePersistenceMongodbIT {
    @Autowired
    private ConferencePersistenceMongodb conferencePersistence;

    @Test
    void testRead() {
        Optional<Conference> conference = this.conferencePersistence.readAll()
                .filter(conference1 -> "Security".equals(conference1.getFieldOfStudy()))
                .findFirst();
        Assertions.assertTrue(conference.isPresent());
        Assertions.assertTrue(conference.get().getConferenceDate().isBefore(LocalDateTime.now()));
        Assertions.assertEquals(true, conference.get().getHasWorkshops());
        Assertions.assertEquals("Toulouse", conference.get().getLocation().getCity());
        Assertions.assertEquals(3, conference.get().getPapers().size());
    }
}
