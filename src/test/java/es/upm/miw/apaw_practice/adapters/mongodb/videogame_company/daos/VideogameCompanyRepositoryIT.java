package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities.VideogameCompanyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestConfig
class VideogameCompanyRepositoryIT{
    @Autowired
    private VideogameCompanyRepository videogameCompanyRepository;
    private static final String CUSTOMIZED_VIDEOGAME_COMPANY = "Square Enix";

    @Test
    void testFindByName(){
        assertTrue(videogameCompanyRepository.findByName(CUSTOMIZED_VIDEOGAME_COMPANY).isPresent());
        VideogameCompanyEntity videogameCompany = videogameCompanyRepository.findByName(CUSTOMIZED_VIDEOGAME_COMPANY).get();
        assertEquals("Japan", videogameCompany.getCountry());
        assertEquals(LocalDate.of(2003,4,1),videogameCompany.getRegistrationDate());
        this.assertVidegameCompanyVideogameName(videogameCompany,"Dragon Quest 11");
        this.assertVidegameCompanyVideogameName(videogameCompany,"Deus Ex Go");
    }

    private void assertVidegameCompanyVideogameName(VideogameCompanyEntity videogameCompany, String videogame){
        assertTrue(videogameCompany.getVideogames()
                .stream()
                .anyMatch(videogameEntity -> videogameEntity.getName().equals(videogame)));
    }

}
