package es.upm.miw.apaw_practice.domain.models.bakery;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductIT {
    @Test
    void testProductBuilder() {
        Product product = new Product.Builder()
            .name("Pan")
            .description("Pan normal")
            .price(new BigDecimal("1.10"))
            .isGlutenFree(true)
            .expirationDate(LocalDate.of(2023, 7, 1))
            .productType(null)
            .build();
        assertEquals("Pan", product.getName());
        assertEquals("Pan normal", product.getDescription());
        assertEquals(true, product.getGlutenFree());
        assertEquals(LocalDate.of(2023, 7, 1), product.getExpirationDate());
        assertEquals(null, product.getProductType());
    }
}
