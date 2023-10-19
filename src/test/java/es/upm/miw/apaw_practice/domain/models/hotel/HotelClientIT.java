package es.upm.miw.apaw_practice.domain.models.hotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HotelClientIT {
    @Test
    void HotelClientBuilderTest() {
        HotelClient client = new HotelClient.Builder().
                dni("12345678A").
                email("example@email.com").
                telephone(111222333).
                partnership(true).
                build();
        assertNotNull(client);
        assertEquals("12345678A", client.getDni());
        assertEquals("example@email.com", client.getEmail());
        assertEquals(111222333, client.getTelephone());
        assertEquals(true, client.getPartnership());
    }
}
