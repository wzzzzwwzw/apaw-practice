package es.upm.miw.apaw_practice.domain.services.videogame_company;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
public class VideogameServiceIT {

    @Autowired
    private VideogameService videogameService;

    @Test
    void testDelete(){
        videogameService.delete("To the Moon");
    }
}
