package es.upm.miw.apaw_practice.adapters.mongodb.conference.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.entities.PaperEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
class PaperRepositoryIT {
    @Autowired
    private PaperRepository paperRepository;

    @Test
    void testFindByDigitalObjectIdentifier() {
        Assertions.assertTrue(this.paperRepository.findByDigitalObjectIdentifier("DOI 1").isPresent());
        PaperEntity paper = this.paperRepository.findByDigitalObjectIdentifier("DOI 1").get();
        Assertions.assertEquals("Paper 1", paper.getTitle());
        Assertions.assertEquals(10, paper.getLength());
        Assertions.assertTrue(paper.getAuthorEntities().stream()
                .anyMatch(author ->
                      "Jorge".equals(author.getName()) &&
                              "Da Silva".equals(author.getSurname()) &&
                              "Mr.".equals(author.getHonorific())
                ));
    }
}
