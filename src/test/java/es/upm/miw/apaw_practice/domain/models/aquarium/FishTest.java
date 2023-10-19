package es.upm.miw.apaw_practice.domain.models.aquarium;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
public class FishTest {
    @Test
    void testBuilder(){
      LocalDate date = LocalDate.of(2023,9,23);
      Fish fish = Fish.builder()
              .species("Catfish")
              .color("Black")
              .dateOfEntrance(date)
              .build();
      Assertions.assertEquals("Catfish",fish.getSpecies());
      Assertions.assertEquals("Black",fish.getColor());
    }
}
