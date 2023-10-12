package es.upm.miw.apaw_practice.adapters.mongodb.conference.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.ConferenceSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.conference.Paper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class PaperPersistenceMongodbIT {
    @Autowired
    private PaperPersistenceMongodb paperPersistence;

    @Autowired
    private ConferenceSeederService conferenceSeederService;

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.paperPersistence.readByDigitalObjectIdentifier("0"));
    }

    @Test
    void testReadCorrect() {
        Paper paper = this.paperPersistence.readByDigitalObjectIdentifier("DOI 3");
        Assertions.assertEquals("Paper 3", paper.getTitle());
        Assertions.assertEquals(8, paper.getLength());
        Assertions.assertEquals(1, paper.getAuthors().size());
        Assertions.assertEquals("Wil", paper.getAuthors().get(0).getName());
    }

    @Test
    void testUpdate() {
        Paper paper = this.paperPersistence.readByDigitalObjectIdentifier("DOI 1");
        paper.setTitle("New title");
        this.paperPersistence.update(paper);

        paper = this.paperPersistence.readByDigitalObjectIdentifier("DOI 1");
        Assertions.assertEquals("New title", paper.getTitle());

        conferenceSeederService.deleteAll();
        conferenceSeederService.seedDatabase();
    }
}
