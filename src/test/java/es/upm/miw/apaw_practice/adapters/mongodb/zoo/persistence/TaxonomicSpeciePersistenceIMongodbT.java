package es.upm.miw.apaw_practice.adapters.mongodb.zoo.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class TaxonomicSpeciePersistenceIMongodbT {
    @Autowired
    private TaxonomicSpeciePersistenceMongodb taxonomicSpeciePersistence;

    @Test
    void testExistSpeciesName() {
        assertFalse(this.taxonomicSpeciePersistence.existSpeciesName("neanderthalensis"));
        assertTrue(this.taxonomicSpeciePersistence.existSpeciesName("lupus"));
    }
}
