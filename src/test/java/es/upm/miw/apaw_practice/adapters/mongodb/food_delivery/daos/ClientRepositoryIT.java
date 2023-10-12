package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.ClientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ClientRepositoryIT {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void testFindByIdentity() {
        assertTrue(this.clientRepository.findByIdentity("ID001").isPresent());
        ClientEntity client = this.clientRepository.findByIdentity("ID001").get();
        assertEquals("customer1@example.com", client.getEmail());
        assertEquals(2, client.getOrders().size());
        assertEquals(false, client.getOrders().get(0).getDelivered());
        assertEquals("PayPal", client.getOrders().get(1).getPaymentMethod());
        assertEquals("123456789", client.getTelephone());


    }
}
