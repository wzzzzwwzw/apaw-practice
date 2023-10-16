package es.upm.miw.apaw_practice.adapters.mongodb.zoo.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.zoo.TaxonomicSpecie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class TaxonomicSpeciePersistenceIMongodbT {
    @Autowired
    private TaxonomicSpeciePersistenceMongodb taxonomicSpeciePersistence;

    @Test
    void testCreate() {
        TaxonomicSpecie newTaxonomicSpecie =
                new TaxonomicSpecie("homo", "habilis", true, "Africa");

        TaxonomicSpecie resulTaxonomicSpecie = this.taxonomicSpeciePersistence.create(newTaxonomicSpecie);
        assertNotNull(resulTaxonomicSpecie);
        assertEquals(newTaxonomicSpecie.toString(), resulTaxonomicSpecie.toString());
    }

    @Test
    void testExistSpeciesName() {
        assertFalse(this.taxonomicSpeciePersistence.existSpeciesName("neanderthalensis"));
        assertTrue(this.taxonomicSpeciePersistence.existSpeciesName("lupus"));
    }
}
