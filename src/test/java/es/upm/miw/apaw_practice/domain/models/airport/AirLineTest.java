package es.upm.miw.apaw_practice.domain.models.airport;

import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import es.upm.miw.apaw_practice.domain.models.airport.builders.AirLineBuilders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AirLineTest {
    @Test
    void testConferenceLocationBuilder() {
        LocalDate date =  LocalDate.of(1978,10,11);
        AirLine airLine = AirLine.builder()
                .name("Catar Airways")
                .dayOfFoundation(date)
                .aricrafts(null)
                .build();

        Assertions.assertEquals("Catar Airways", airLine.getName());
        Assertions.assertEquals(date, airLine.getDayOfFoundation());
        Assertions.assertNull(airLine.getAircrafts());
    }
}
