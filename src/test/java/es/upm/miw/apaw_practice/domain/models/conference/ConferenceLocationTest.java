package es.upm.miw.apaw_practice.domain.models.conference;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConferenceLocationTest {

    @Test
    void testConferenceLocationBuilder() {
        ConferenceLocation conferenceLocation = ConferenceLocation.builder()
                .id("1")
                .city("Mondragon")
                .building("Amaia Antzokia")
                .hall("Main Hall")
                .build();

        Assertions.assertEquals("1", conferenceLocation.getId());
        Assertions.assertEquals("Mondragon", conferenceLocation.getCity());
        Assertions.assertEquals("Amaia Antzokia", conferenceLocation.getBuilding());
        Assertions.assertEquals("Main Hall", conferenceLocation.getHall());
    }
}
