package es.upm.miw.apaw_practice.domain.services.bakery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.persistence_ports.bakery.ProductPersistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

@TestConfig
public class ProductServiceIT {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductPersistence productPersistence;

    @Test
    void testUpdatePrice() {
        this.productService.updatePrice("Pan integral", "300.20");
        assertEquals(new BigDecimal("300.20"), this.productPersistence.findByName("Pan integral").getPrice());
    }
    
}
