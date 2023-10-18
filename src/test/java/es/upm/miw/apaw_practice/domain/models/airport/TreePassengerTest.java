package es.upm.miw.apaw_practice.domain.models.airport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreePassengerTest {

    @Test
    void testTreeStudentsComposite() {
        PassengersComposite passengersComposite = new PassengersComposite("Fer Torres");
        Assertions.assertTrue(passengersComposite.isComposite());

        Passenger passenger = new Passenger("Fer Torres", 41, "789654123");
        passengersComposite.add(passenger);
        Assertions.assertEquals(1, passengersComposite.getTreePassengers().size());

        passengersComposite.remove(passenger);
        Assertions.assertEquals(0, passengersComposite.getTreePassengers().size());
    }

    @Test
    void testTreeStudentsLeaf() {
        Passenger passenger = new Passenger("Fer Torres", 70, "678901234");
        Assertions.assertFalse(passenger.isComposite());

        Assertions.assertThrows(UnsupportedOperationException.class, () -> passenger.add(passenger));
    }
}
