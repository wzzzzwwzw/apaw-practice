package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities.VideogameEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestConfig
class VideogameRepositoryIT{
    @Autowired
    private VideogameRepository videogameRepository;
    private static final String CUSTOMIZED_VIDEOGAME = "Shin Megami Tensei V";

    @Test
    void testFindByName(){
        assertTrue(videogameRepository.findByName(CUSTOMIZED_VIDEOGAME).isPresent());
        VideogameEntity videogame = videogameRepository.findByName(CUSTOMIZED_VIDEOGAME).get();
        assertEquals(new BigDecimal("59.99"), videogame.getPrice());
        assertEquals(LocalDate.of(2011,11,11), videogame.getReleaseDate());
        assertEquals("Unreal Engine", videogame.getGameEngine().getName());
        this.assertVideogameFeatureGenres(videogame,"RPG");
        this.assertVideogameFeatureGenres(videogame,"Action");
        this.assertVideogameFeatureGenres(videogame,"Visual Novel");
    }

    private void assertVideogameFeatureGenres(VideogameEntity videogame, String featureGenre){
        assertTrue(videogame.getFeatures()
                .stream()
                .anyMatch(feature -> feature.getGenre().equals(featureGenre)));
    }
}
