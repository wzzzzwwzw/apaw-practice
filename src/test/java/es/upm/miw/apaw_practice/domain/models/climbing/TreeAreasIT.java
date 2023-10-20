package es.upm.miw.apaw_practice.domain.models.climbing;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class TreeAreasIT {

    private Area area1;
    private Area area2;
    private AreasComposite areasComposite;

    @BeforeEach
    void before() {
        area1 = new Area("Area A", "Location A", true, new ArrayList<>(), new Expedition("1", null, null));
        area2 = new Area("Area B", "Location B", false, new ArrayList<>(), new Expedition("2", null, null));

        areasComposite = new AreasComposite("Composite Area");
        areasComposite.add(area1);
    }

    @Test
    void testAreaAsLeaf() {
        assertFalse(area1.isComposite());
        assertFalse(area2.isComposite());
        assertThrows(UnsupportedOperationException.class, () -> area1.add(area2));
    }

    @Test
    void testAreasComposite() {
        assertTrue(areasComposite.isComposite());
    }

    @Test
    void testAreasCompositeAddAndRemove() {
        assertEquals(1, areasComposite.getTreeAreas().size());
        areasComposite.add(area2);
        assertEquals(2, areasComposite.getTreeAreas().size());

        areasComposite.remove(area1);
        assertEquals(1, areasComposite.getTreeAreas().size());
        assertTrue(areasComposite.getTreeAreas().contains(area2));
    }
}
