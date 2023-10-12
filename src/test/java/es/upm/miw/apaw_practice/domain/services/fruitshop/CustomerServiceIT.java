package es.upm.miw.apaw_practice.domain.services.fruitshop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.fruitShop.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class CustomerServiceIT {

    @Autowired
    private CustomerService customerService;

    @Test
    void testFindById(){
        Customer customer = customerService.findByIdCustomer(1);
        assertNotNull(customer);
        assertEquals("688-576-678",customer.getPhone());
        assertEquals("ada2@gmail.com",customer.getEmail());

    }
}
