package es.upm.miw.apaw_practice.domain.models.subway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineIT {

    @Test
    void testBuilder() {
        Line line = new Line.Builder()
                .label("L1")
                .color("red")
                .works(true)
                .build();
        assertEquals("L1", line.getLabel());
        assertEquals("red", line.getColor());
        assertEquals(true, line.getWorking());
    }

    @Test
    void testLineComposite() {
        LineComposite lineComposite = new LineComposite("L1");
        assertTrue(lineComposite.isComposite());

        Line line = new Line.Builder()
                .label("L1")
                .color("red")
                .works(true)
                .build();
        lineComposite.add(line);
        assertEquals(1, lineComposite.getTreeLines().size());

        lineComposite.remove(line);
        assertEquals(0, lineComposite.getTreeLines().size());
    }

    @Test
    void testLineLeaf() {
        Line line = new Line.Builder()
                .label("L1")
                .color("red")
                .works(true)
                .build();
        assertFalse(line.isComposite());
    }
}
