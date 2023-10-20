package es.upm.miw.apaw_practice.domain.models.olympic_games;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MedalIT {

    @Test
    void testMedalTreeComposite() {
        MedalsComposite medalComposite = new MedalsComposite("MED999");
        Assertions.assertTrue(medalComposite.isComposite());


        Competitor winner = new Competitor("Marco", "Italy", 24);
        Medal medal = new Medal("MED777", "Gold",true, "Football", winner);
        medalComposite.add(medal);
        Assertions.assertEquals(1, medalComposite.getTreeMedals().size());

        medalComposite.remove(medal);
        Assertions.assertEquals(0, medalComposite.getTreeMedals().size());
    }

    @Test
    void testHotelActivitiesTreeLeaf() {
        Competitor winner = new Competitor("Marco", "Italy", 24);
        Medal medal = new Medal("MED777", "Gold",true, "Football", winner);
        Assertions.assertFalse(medal.isComposite());

        Assertions.assertThrows(UnsupportedOperationException.class, () -> medal.add(medal));
    }
}
