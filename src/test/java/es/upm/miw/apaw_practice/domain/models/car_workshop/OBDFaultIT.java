package es.upm.miw.apaw_practice.domain.models.car_workshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OBDFaultIT {

    @Test
    void testOBDFaultBuilder() {
        OBDFault obdFaultOnlyCode = new OBDFault.Builder()
                .code("P0123")
                .build();

        assertEquals(obdFaultOnlyCode.getCode(), "P0123");
        assertNull(obdFaultOnlyCode.getDescription());
        assertNull(obdFaultOnlyCode.getIsITVSafe());
        assertNull(obdFaultOnlyCode.getSolution());

        OBDFault obdFaultOnlyCodeAndDescription = new OBDFault.Builder()
                .code("P0123")
                .description("Throttle/Pedal Position Sensor/Switch A Circuit High Input")
                .build();

        assertEquals(obdFaultOnlyCodeAndDescription.getCode(), "P0123");
        assertEquals(obdFaultOnlyCodeAndDescription.getDescription(), "Throttle/Pedal Position Sensor/Switch A Circuit High Input");
        assertNull(obdFaultOnlyCodeAndDescription.getIsITVSafe());
    }

    @Test
    void testComposite() {
        TreeOBDFaults obdFaults = new OBDFaultComposite("Car");
        TreeOBDFaults chasisOBdFaults = new OBDFaultComposite("Chasis");
        TreeOBDFaults engineOBdFaults = new OBDFaultComposite("Engine");
        obdFaults.add(chasisOBdFaults);
        obdFaults.add(engineOBdFaults);

        TreeOBDFaults chasisOBDFaultFront = new OBDFaultComposite("Front");

        chasisOBdFaults.add(chasisOBDFaultFront);

        OBDFault obdFaultFront = new OBDFault.Builder()
                .code("P0123")
                .description("Broken Glass")
                .isITVSafe(false)
                .solution("Replace the glass")
                .build();

        chasisOBDFaultFront.add(obdFaultFront);

        assertEquals(obdFaults.family(), "Car");
        assertEquals(chasisOBdFaults.family(), "Chasis");
        assertEquals(engineOBdFaults.family(), "Engine");

        assertEquals(chasisOBDFaultFront.family(), "Front");
        assertEquals(obdFaultFront.family(), "P0123");

        assertTrue(obdFaults.isComposite());
        assertTrue(chasisOBdFaults.isComposite());
        assertTrue(engineOBdFaults.isComposite());
        assertTrue(chasisOBDFaultFront.isComposite());
        assertFalse(obdFaultFront.isComposite());
    }
}
