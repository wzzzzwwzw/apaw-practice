package es.upm.miw.apaw_practice.domain.models.fruitShop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FruitSpecieIT {

    @Test
    void testFruitSpecieBuilder(){
        FruitSpecie fruitSpecie = new FruitSpecie.Builder()
                .specie("specie_example")
                .season("season_example")
                .size(8)
                .build();
        assertNotNull(fruitSpecie);
        assertEquals("specie_example", fruitSpecie.getSpecie());
        assertEquals("season_example", fruitSpecie.getSeason());
        assertEquals(8, fruitSpecie.getSize());


    }
}
