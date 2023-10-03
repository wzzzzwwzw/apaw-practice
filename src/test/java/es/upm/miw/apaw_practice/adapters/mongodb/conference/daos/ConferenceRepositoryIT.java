package es.upm.miw.apaw_practice.adapters.mongodb.conference.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@TestConfig
class ConferenceRepositoryIT {
    @Autowired
    private ConferenceRepository conferenceRepository;

    @Test
    void testCreateAndRead() {
        Assertions.assertTrue(this.conferenceRepository.findAll().stream()
                .anyMatch(conference ->
                        conference.getConferenceDate() != null &&
                                conference.getConferenceDate().isAfter(LocalDateTime.now()) &&
                                conference.getHasWorkshops() &&
                                "DevOps".equals(conference.getFieldOfStudy()) &&
                                "San Antonio".equals(conference.getLocationEntity().getCity()) &&
                                2 == conference.getPapersEntities().size() && conference.getPapersEntities().stream()
                                .anyMatch(paper ->
                                        "Paper 5".equals(paper.getTitle()))
                        ));
    }
}
