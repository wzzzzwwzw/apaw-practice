package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.CustomerEntity;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


@TestConfig
public class CustomerRepositoryIT {

    private static final Integer CUSTOMER_FIND_ID = 2;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testReadById() {

        assertTrue(this.customerRepository.findByIdCustomer(CUSTOMER_FIND_ID).isPresent());
        CustomerEntity customer = this.customerRepository.findByIdCustomer(CUSTOMER_FIND_ID).get();
        assertEquals("678-236-900", customer.getPhone());
        assertEquals("4577eric@gmail.com", customer.getEmail());

    }
}
