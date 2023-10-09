package es.upm.miw.apaw_practice.adapters.mongodb.conference.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.ConferenceSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.conference.ConferenceLocation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@TestConfig
class ConferenceLocationPersistenceMongodbIT {
    @Autowired
    private ConferenceLocationPersistenceMongodb conferenceLocationPersistence;

    @Autowired
    private ConferenceSeederService conferenceSeederService;

    @Test
    void testReadNotFound() {
        Assertions.assertThrows(NotFoundException.class, () -> this.conferenceLocationPersistence.read("NaN"));
    }

    @Test
    void testReadAll() {
        Assertions.assertEquals(3, conferenceLocationPersistence.readAll().toList().size());
    }

    @Test
    void testReadById() {
        Optional<ConferenceLocation> conferenceLocation = this.conferenceLocationPersistence.readAll()
                .filter(conferenceLocation1 -> "Toulouse".equals(conferenceLocation1.getCity()))
                .findFirst();
        Assertions.assertTrue(conferenceLocation.isPresent());

        ConferenceLocation conferenceLocationById = this.conferenceLocationPersistence.read(conferenceLocation.get().getId());

        Assertions.assertNotNull(conferenceLocationById.getId());
        Assertions.assertEquals("Toulouse", conferenceLocationById.getCity());
    }

    @Test
    void testUpdate() {
        Optional<ConferenceLocation> conferenceLocation = this.conferenceLocationPersistence.readAll()
                .filter(conferenceLocation1 -> "Toulouse".equals(conferenceLocation1.getCity()))
                .findFirst();
        Assertions.assertTrue(conferenceLocation.isPresent());
        ConferenceLocation newConferenceLocation = new ConferenceLocation("Toulouse", "Mercure Toulouse Centre Compans", "New Hall");
        this.conferenceLocationPersistence.update(conferenceLocation.get().getId(), newConferenceLocation);
        Assertions.assertEquals("New Hall", newConferenceLocation.getHall());
        conferenceSeederService.deleteAll();
        conferenceSeederService.seedDatabase();
    }
}
