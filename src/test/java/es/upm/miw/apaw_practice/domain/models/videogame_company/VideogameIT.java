package es.upm.miw.apaw_practice.domain.models.videogame_company;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VideogameIT {

    @Test
    void testVideogameBuilder(){
        Feature feature = new Feature("Dungeon Crawler","Turn Based",false);
        List<Feature> features = new ArrayList<>();
        features.add(feature);

        Videogame videogame = Videogame.build()
                .name("Etrian Odyssey")
                .price(new BigDecimal("49.99"))
                .releaseDate(LocalDate.of(2007,1,18))
                .engine(new GameEngine("Atlus Engine","C C++","Paid"))
                .features(features)
                .build();

        assertNotNull(videogame);
        assertEquals("Etrian Odyssey",videogame.getName());
        assertEquals(new BigDecimal("49.99"),videogame.getPrice());
        assertEquals(LocalDate.of(2007,1,18),videogame.getReleaseDate());

        assertEquals("Atlus Engine", videogame.getGameEngine().getName());
        assertEquals("Dungeon Crawler", videogame.getFeatures().get(0).getGenre());
    }
}
