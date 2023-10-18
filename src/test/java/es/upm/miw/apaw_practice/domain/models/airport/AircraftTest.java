package es.upm.miw.apaw_practice.domain.models.airport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AircraftTest {
    @Test
    void testAircraftBuilder() {
        LocalDate date =  LocalDate.of(1978,10,11);
        Aircraft aircraft = Aircraft.builder()
                .dateOfLastRevision(date)
                .capacity(340)
                .model("Boeing 747")
                .numberPlate("590PDS")
                .build();

        Assertions.assertEquals("Boeing 747", aircraft.getModel());
        Assertions.assertEquals("590PDS", aircraft.getNumberPlate());
        Assertions.assertEquals(date, aircraft.getDateOfLastRevision());
        Assertions.assertEquals(340, aircraft.getCapacity());
    }
}
