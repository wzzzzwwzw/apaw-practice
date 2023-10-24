package es.upm.miw.apaw_practice.domain.models.basketball;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.basketball.composite.TreePlayers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class TreePlayersIT {

    private Player player1, player2, player3;
    private PlayerComposite playerComposite;

    @BeforeEach
    void before() {
        this.player1 = new Player("email1@gmail.com", "alero", 19);
        this.player2 = new Player("email2@gmail.com", "base", 20);
        this.player3 = new Player("email3@gmail.com", "pivot", 21);
        this.playerComposite = new PlayerComposite("Composite Players");
    }

    @Test
    void testPlayerAsLeaf() {
        assertFalse(this.player1.isComposite());
        assertFalse(this.player2.isComposite());
        assertFalse(this.player3.isComposite());
        assertThrows(UnsupportedOperationException.class, () -> this.player1.add(player2));
    }
    @Test
    void testPlayerComposite() {
        assertTrue(this.playerComposite.isComposite());
    }

    @Test
    void testAddComposite() {
        this.playerComposite.add(player1);
        this.playerComposite.add(player2);

        List<TreePlayers> components = this.playerComposite.getTreePlayerss();
        assertEquals(2, components.size());
        assertEquals(player1, components.get(0));
        assertEquals(player2, components.get(1));
    }

    @Test
    void testRemoveComposite() {
        this.playerComposite.add(player1);
        this.playerComposite.add(player2);
        this.playerComposite.remove(player1);

        List<TreePlayers> components = this.playerComposite.getTreePlayerss();
        assertEquals(1, components.size());
        assertEquals(player2, components.get(0));
    }
}
