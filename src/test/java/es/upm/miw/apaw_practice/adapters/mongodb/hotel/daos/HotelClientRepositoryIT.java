package es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelClientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class HotelClientRepositoryIT {
    @Autowired
    private HotelClientRepository ClientRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.ClientRepository.findByDni("11122233F").isPresent());
        HotelClientEntity firstClient = this.ClientRepository.findByDni("11122233F").get();
        assertEquals(firstClient.getDni(),"11122233F");
        assertEquals(firstClient.getEmail(),"sixth@email.com");
        assertEquals(firstClient.getTelephone(),111222338);
        assertFalse(firstClient.getPartnership());
    }
}
