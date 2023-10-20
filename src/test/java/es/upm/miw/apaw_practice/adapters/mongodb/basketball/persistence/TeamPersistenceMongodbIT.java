package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.TeamBasketballRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.TeamBasketballEntity;
import es.upm.miw.apaw_practice.domain.models.basketball.Pavilion;
import es.upm.miw.apaw_practice.domain.models.basketball.Player;
import es.upm.miw.apaw_practice.domain.models.basketball.Team;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.TeamPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class TeamPersistenceMongodbIT {

    @Autowired
    private TeamPersistence teamPersistence;

    @Autowired
    private TeamBasketballRepository teamBasketballRepository;

    @Test
    void testReadByAlias() {
        TeamBasketballEntity teamBasketballEntity = this.teamBasketballRepository.findByAlias("alias1").orElse(null);
        assertNotNull(teamBasketballEntity);

        Team team = this.teamPersistence.readByAlias("alias1");
        assertEquals("alias1", team.getAlias());
        assertEquals(2, team.getNumPlayers());
        assertEquals("Alberto", team.getCoach());
        List<String> expectedEmails = Arrays.asList("email1@gmail.com", "email2@gmail.com");

        List<String> expectedPavilionNames = Arrays.asList("pavilion1", "pavilion2");

        List<String> playerEmails = team.getPlayers().stream().map(Player::getEmail).collect(Collectors.toList());

        List<String> pavilionNames = team.getPavilions().stream().map(Pavilion::getPavname).collect(Collectors.toList());

        assertEquals(expectedEmails, playerEmails);
        assertEquals(expectedPavilionNames, pavilionNames);
    }


    @Test
    void testUpdate() {
        Team team = this.teamPersistence.readByAlias("alias1");
        team.getPlayers().get(0).setAge(10);
        team.getPlayers().get(0).setPosition("pivot");
        this.teamPersistence.update(team);
        team = this.teamPersistence.readByAlias("alias1");
        assertTrue(team.getPlayers().size() > 0);
        assertEquals(10, team.getPlayers().get(0).getAge());
        assertEquals("pivot", team.getPlayers().get(0).getPosition());
        assertEquals("email2@gmail.com", team.getPlayers().get(1).getEmail());
        assertEquals(2, team.getPavilions().size());
    }
}
