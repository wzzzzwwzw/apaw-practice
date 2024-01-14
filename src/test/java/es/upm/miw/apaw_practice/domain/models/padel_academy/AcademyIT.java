package es.upm.miw.apaw_practice.domain.models.padel_academy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AcademyIT {
    private final Instructor instructor = new Instructor("12345678A", "Ana", 654456545);
    private final Academy academy = new Academy("Ocio y Deporte Canal", "Avda. Filipinas, esq. Pablo Iglesias, 28003", "Madrid", Arrays.asList(instructor));

    @Test
    void testTreeAcademiesComposite() {
        AcademiesComposite academiesComposite = new AcademiesComposite("Academy");
        Assertions.assertTrue(academiesComposite.isComposite());

        academiesComposite.add(academy);
        Assertions.assertEquals(1, academiesComposite.getTreeAcademies().size());

        academiesComposite.remove(academy);
        Assertions.assertEquals(0, academiesComposite.getTreeAcademies().size());
    }

    @Test
    void testTreeAcademiesLeaf() {
        Assertions.assertFalse(academy.isComposite());
        Assertions.assertThrows(UnsupportedOperationException.class, () -> academy.add(academy));
    }
}
