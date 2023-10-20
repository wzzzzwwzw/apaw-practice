package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.videogame_company.Videogame;
import es.upm.miw.apaw_practice.domain.models.videogame_company.VideogameCompany;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class VideogameCompanyPersistenceMongodbIT {

    @Autowired
    private VideogameCompanyPersistenceMongodb videogameCompanyPersistence;

    @Test
    void testCreateVideogameCompany(){
        VideogameCompany videogameCompany = this.videogameCompanyPersistence.create(
                new VideogameCompany("Nippon Ichi Software",
                        "Japan",
                        LocalDate.of(1993,7,12))
        );

        VideogameCompany newVideogameCompany = this.videogameCompanyPersistence.create(videogameCompany);
        assertNotNull(newVideogameCompany);
        assertEquals(videogameCompany.getName(), newVideogameCompany.getName());
        assertEquals(videogameCompany.getCountry(), newVideogameCompany.getCountry());
        assertEquals(videogameCompany.getRegistrationDate(), newVideogameCompany.getRegistrationDate());
    }

    @Test
    void testVideogameCompanyNotExist(){
        assertFalse(this.videogameCompanyPersistence.existVideogameCompanyName("Activision"));
    }

    @Test
    void testVideogameCompanyExist(){
        assertTrue(this.videogameCompanyPersistence.existVideogameCompanyName("Square Enix"));
    }

    @Test
    void testFindVideogamesByCompanyCountry(){
        List<Videogame> videogames = this.videogameCompanyPersistence.findVideogamesByCompanyCountry("Japan");
        assertEquals(5,videogames.size());
    }

    @Test
    void NotFoundVideogamesByCompanyCountry(){
        List<Videogame> videogames = this.videogameCompanyPersistence.findVideogamesByCompanyCountry("Spain");
        assertNotNull(videogames);
        assertEquals(0,videogames.size());
    }



}
