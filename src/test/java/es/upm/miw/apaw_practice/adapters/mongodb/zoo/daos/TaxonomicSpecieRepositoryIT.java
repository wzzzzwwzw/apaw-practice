package es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.TaxonomicSpecieEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class TaxonomicSpecieRepositoryIT {
    @Autowired
    private TaxonomicSpecieRepository taxonomicSpecieRepository;

    @Test
    void testFindBySpeciesName() {
        assertTrue(this.taxonomicSpecieRepository.findBySpeciesName("familiaris").isPresent());
        TaxonomicSpecieEntity taxonomicSpecie = this.taxonomicSpecieRepository.findBySpeciesName("familiaris").get();
        assertEquals("familiaris", taxonomicSpecie.getSpeciesName());
        assertEquals("Canis", taxonomicSpecie.getGenusName());
        assertFalse(taxonomicSpecie.getInDangerOfExtinction());
        assertEquals("human houses", taxonomicSpecie.getHabitat());
    }


}
