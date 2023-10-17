package es.upm.miw.apaw_practice.domain.models.football_competition;

import es.upm.miw.apaw_practice.domain.models.conference.Paper;
import es.upm.miw.apaw_practice.domain.models.conference.PaperComposite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TreeFootballPlayersIT {
    @Test
    void testTreeFootballPlayersComposite() {
        TreeFootballPlayersComposite composite =
                new TreeFootballPlayersComposite("Composite");
        TreeFootballPlayersComposite subcomposite =
                new TreeFootballPlayersComposite("Subcomposite");
        composite.add(subcomposite);
        Assertions.assertTrue(composite.isComposite());
        Assertions.assertTrue(subcomposite.isComposite());

        FootballPlayerBuilders.Name builderLionel = FootballPlayer.builder();
        FootballPlayer lionel = builderLionel.name("Lionel Messi").build();
        TreeFootballPlayersLeaf firstLeaf = new TreeFootballPlayersLeaf(lionel);
        subcomposite.add(firstLeaf);

        FootballPlayerBuilders.Name builderCristiano = FootballPlayer.builder();
        FootballPlayer cristiano = builderCristiano.name("Cristiano Ronaldo").build();
        TreeFootballPlayersLeaf secondLeaf = new TreeFootballPlayersLeaf(cristiano);
        subcomposite.add(secondLeaf);

        assertEquals(1, composite.getTreeFootballPlayers().size());
        assertEquals(2, subcomposite.getTreeFootballPlayers().size());
        assertFalse(subcomposite.getTreeFootballPlayers().get(0).isComposite());
        assertFalse(subcomposite.getTreeFootballPlayers().get(1).isComposite());
        assertEquals("Lionel Messi", subcomposite.getTreeFootballPlayers().get(0).name());
        assertEquals("Cristiano Ronaldo", subcomposite.getTreeFootballPlayers().get(1).name());
    }
}
