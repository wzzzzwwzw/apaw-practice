package es.upm.miw.apaw_practice.domain.models.fruitShop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerIT {

    @Test
    void testCustomerBuilder(){
        Customer customer = new Customer.Builder()
                .idCustomer(1)
                .phone("111_222_333")
                .email("123@gmail.com")
                .build();
        assertNotNull(customer);
        assertEquals("111_222_333", customer.getPhone());
        assertEquals("123@gmail.com", customer.getEmail());

    }
}
