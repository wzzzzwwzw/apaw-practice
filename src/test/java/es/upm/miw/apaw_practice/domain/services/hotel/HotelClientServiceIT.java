package es.upm.miw.apaw_practice.domain.services.hotel;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelBooking;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class HotelClientServiceIT {
    @Autowired
    private HotelClientService clientService;

    @Test
    void testDeleteClient(){
        assertTrue(this.clientService.existClient("11122233C"));
        clientService.deleteClient("11122233C");
        assertFalse(this.clientService.existClient("11122233C"));
    }
}
