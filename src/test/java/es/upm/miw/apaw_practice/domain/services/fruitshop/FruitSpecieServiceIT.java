package es.upm.miw.apaw_practice.domain.services.fruitshop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitSpecie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FruitSpecieServiceIT {

    @Autowired
    private FruitSpecieService fruitSpecieService;

    @Test
    void testCreate(){
       FruitSpecie fruitSpecie = this.fruitSpecieService.create(new FruitSpecie("NO_EXIT_SPECIE", "NO_EXIT_SEASON", 8));
        assertNotNull(fruitSpecie);
        assertEquals("NO_EXIT_SPECIE",fruitSpecie.getSpecie() );
        assertEquals("NO_EXIT_SEASON", fruitSpecie.getSeason() );
        assertEquals(8,fruitSpecie.getSize());

    }

    @Test
    void testCreateAlreadyExist(){
        FruitSpecie fruitSpecie = new FruitSpecie("Tropical","Spring",8);
        assertThrows(ConflictException.class, ()-> this.fruitSpecieService.create(fruitSpecie));
    }
}
