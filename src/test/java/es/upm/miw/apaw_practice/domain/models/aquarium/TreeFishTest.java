package es.upm.miw.apaw_practice.domain.models.aquarium;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TreeFishTest {
    @Test
    void testTreeFishComposite(){
        FishComposite fishComposite = new FishComposite("Catfish");
        Assertions.assertTrue(fishComposite.isComposite());

        Fish fish = new Fish("Catfish","Black", LocalDate.of(2023,9,23));
        fishComposite.add(fish);
        Assertions.assertEquals(1,fishComposite.getTreeFishes().size());

        fishComposite.remove(fish);
        Assertions.assertEquals(0,fishComposite.getTreeFishes().size());
    }
    @Test
    void testTreeFishLeaf(){
        Fish fish = new Fish("Catfish","Black", LocalDate.of(2023,9,23));
        Assertions.assertFalse(fish.isComposite());
        Assertions.assertThrows(UnsupportedOperationException.class,()-> fish.add(fish));
    }
}
