package es.upm.miw.apaw_practice.domain.services.videogame_company;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.videogame_company.Videogame;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class VideogameServiceIT {

    @Autowired
    private VideogameService videogameService;

    @Test
    void testDelete(){
        videogameService.delete("To the Moon");
    }

    @Test
    void testUpdateReleaseDateByName(){
        Videogame videogame = videogameService.updateReleaseDateByName("Super Bomberman R");
        assertEquals("Super Bomberman R", videogame.getName());
        assertTrue(videogame.getReleaseDate().atStartOfDay().isEqual(LocalDate.now().atStartOfDay()));
    }

    @Test
    void testUpdateReleaseDateByNameNotFound(){
        assertThrows(NotFoundException.class, () -> this.videogameService.updateReleaseDateByName("x"));
    }

    @Test
    void testFindSumOfVideogamePricesByGameEngineLicense(){
        BigDecimal result = this.videogameService.findSumOfVideogamePricesByGameEngineLicence("Freemium");
        assertEquals(new BigDecimal("236.95"), result);
    }

    @Test
    void testNotFoundSumOfVideogamePricesByGameEngineLicense(){
        BigDecimal result = this.videogameService.findSumOfVideogamePricesByGameEngineLicence("x");
        assertEquals(new BigDecimal("0"), result);
    }
}
