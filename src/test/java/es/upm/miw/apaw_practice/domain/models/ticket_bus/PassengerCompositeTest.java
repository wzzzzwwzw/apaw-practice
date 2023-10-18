package es.upm.miw.apaw_practice.domain.models.ticket_bus;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class PassengerCompositeTest {


    private PassengerLeaf passenger1;
    private PassengerLeaf passenger2;
    private PassengerComposite composite1;

    @BeforeEach
    void before() {
        List<Passenger> passengers = List.of(
                new Passenger("555","wael louati",24767211,true,new ArrayList<>()),
                new Passenger("888","lww",21645486,true,new ArrayList<>())
        );

        passenger1 = new PassengerLeaf(new Passenger("Y12345678","wael louati",24767211,
                true,new ArrayList<>()));
        passenger2 = new PassengerLeaf(new Passenger("Y12345678","wael louati",24767211,
                true,new ArrayList<>()));

        composite1 = new PassengerComposite("composite1");
        composite1.add(passenger1);
    }

    @Test
    void testPassengerAsCompositeLeaf() {
        assertFalse(passenger1.isComposite());
        assertFalse(passenger2.isComposite());
    }

    @Test
    void testCreatePassengerCComposite() {
        assertEquals("composite1", composite1.getFullName());
        assertTrue(composite1.isComposite());
    }

    @Test
    void testPassengerCompositeAdd() {
        composite1.add(passenger2);
        assertEquals(2, composite1.numberOfNodes());
    }

    @Test
    void testPassengerCompositeRemove() {
        composite1.remove(passenger1);
        assertEquals(0, composite1.numberOfNodes());
    }
}
