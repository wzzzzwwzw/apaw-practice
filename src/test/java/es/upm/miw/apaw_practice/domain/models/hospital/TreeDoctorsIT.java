package es.upm.miw.apaw_practice.domain.models.hospital;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreeDoctorsIT {
    @Test
    void testTreeDoctorsComposite() {
        DoctorsComposite doctorsComposite = new DoctorsComposite("M9999");
        Assertions.assertTrue(doctorsComposite.isComposite());

        Doctor doctor = new Doctor("M9999", "TEST", new Department("TESTdeparment",999,9));
        doctorsComposite.add(doctor);
        Assertions.assertEquals(1, doctorsComposite.getTreeDoctors().size());

        doctorsComposite.remove(doctor);
        Assertions.assertEquals(0, doctorsComposite.getTreeDoctors().size());
    }

    @Test
    void testTreeDoctorsLeaf() {
        Doctor doctor = new Doctor("M9999", "TEST", new Department("TESTdeparment",999,9));
        Assertions.assertFalse(doctor.isComposite());

        Assertions.assertThrows(UnsupportedOperationException.class, () -> doctor.add(doctor));
    }
}
