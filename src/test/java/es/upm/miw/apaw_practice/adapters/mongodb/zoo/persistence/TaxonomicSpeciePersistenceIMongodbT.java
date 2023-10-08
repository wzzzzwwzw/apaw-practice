package es.upm.miw.apaw_practice.adapters.mongodb.zoo.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.TaxonomicSpeciePersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class TaxonomicSpeciePersistenceIMongodbT {
    @Autowired
    private TaxonomicSpeciePersistence taxonomicSpeciePersistence;

    @Test
    void testExistSpeciesName() {
        assertFalse(taxonomicSpeciePersistence.existSpeciesName("neanderthalensis"));
        assertTrue(taxonomicSpeciePersistence.existSpeciesName("lupus"));
    }
}
