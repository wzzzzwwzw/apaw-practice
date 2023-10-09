package es.upm.miw.apaw_practice.domain.services.zoo;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.zoo.TaxonomicSpecie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


@TestConfig
public class TaxonomicSpecieServiceIT {

    @Autowired
    private TaxonomicSpecieService taxonomicSpecieService;


    @Test
    void testCreate() {
        TaxonomicSpecie taxonomicSpecie =
                new TaxonomicSpecie("homo", "habilis", true, "Africa");
        TaxonomicSpecie result = taxonomicSpecieService.create(taxonomicSpecie);
        assertNotNull(result);
        assertEquals("habilis", result.getSpeciesName());
        assertEquals("homo", result.getGenusName());
        assertTrue(result.getInDangerOfExtinction());
        assertEquals("Africa", result.getHabitat());

    }

    @Test
    void testSearch() {
        this.taxonomicSpecieService.findByVaccineName("Canis Flu 2023");

    }

}
