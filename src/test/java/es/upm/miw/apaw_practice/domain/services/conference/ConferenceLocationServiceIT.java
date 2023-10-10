package es.upm.miw.apaw_practice.domain.services.conference;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.conference.ConferenceLocation;
import es.upm.miw.apaw_practice.domain.persistence_ports.conference.ConferenceLocationPersistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@TestConfig
class ConferenceLocationServiceIT {

    @Autowired
    private ConferenceLocationService conferenceLocationService;

    @Autowired
    private ConferenceLocationPersistence conferenceLocationPersistence;

    @Test
    void testUpdateHall() {
        String newHallName = "New Hall";
        Optional<ConferenceLocation> conferenceLocation = this.conferenceLocationPersistence.readAll()
                .filter(conferenceLocation1 -> "Student Union".equals(conferenceLocation1.getHall()))
                .findFirst();

        Assertions.assertNotNull(conferenceLocation);
        this.conferenceLocationService.updateHall(conferenceLocation.get().getId(), newHallName);
        Assertions.assertTrue(this.conferenceLocationPersistence.readAll()
                .anyMatch(conferenceLocation1 -> conferenceLocation.get().getId().equals(conferenceLocation1.getId())
                && newHallName.equals(conferenceLocation1.getHall())));
    }
}
