package es.upm.miw.apaw_practice.domain.services.videogame_company;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.videogame_company.VideogameCompany;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class VideogameCompanyServiceIT {
    @Autowired
    VideogameCompanyService videogameCompanyService;

    @Test
    void testCreateVideogameCompany(){
        VideogameCompany videogameCompany = this.videogameCompanyService.create(
                new VideogameCompany(
                        "Bamtang Games", "Peru", LocalDate.of(2002,1,1)));
        assertNotNull(videogameCompany);
        assertEquals("Bamtang Games", videogameCompany.getName());
        assertEquals("Peru", videogameCompany.getCountry());
        assertEquals(LocalDate.of(2002,1,1), videogameCompany.getRegistrationDate());
    }
}
