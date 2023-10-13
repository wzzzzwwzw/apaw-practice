package es.upm.miw.apaw_practice.domain.models.car_workshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OBDFaultIT {

    @Test
    void testOBDFaultBuilder() {
        OBDFault obdFaultOnlyCode = new OBDFault.Builder()
                .code("P0123")
                .build();

        assertEquals(obdFaultOnlyCode.getCode(),"P0123");
        assertNull(obdFaultOnlyCode.getDescription());
        assertNull(obdFaultOnlyCode.getIsITVSafe());
        assertNull(obdFaultOnlyCode.getSolution());

        OBDFault obdFaultOnlyCodeAndDescription = new OBDFault.Builder()
                .code("P0123")
                .description("Throttle/Pedal Position Sensor/Switch A Circuit High Input")
                .build();

        assertEquals(obdFaultOnlyCodeAndDescription.getCode(),"P0123");
        assertEquals(obdFaultOnlyCodeAndDescription.getDescription(),"Throttle/Pedal Position Sensor/Switch A Circuit High Input");
        assertNull(obdFaultOnlyCodeAndDescription.getIsITVSafe());
    }
}
