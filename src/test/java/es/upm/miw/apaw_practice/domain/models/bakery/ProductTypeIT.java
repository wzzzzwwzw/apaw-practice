package es.upm.miw.apaw_practice.domain.models.bakery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTypeIT {
    @Test
    void testProductTypeBuilder() {
        ProductType productType = new ProductType.Builder()
            .name("Tartas")
            .description("Nuestras tartas")
            .code("TAR")
            .build();
        assertEquals("Tartas", productType.getName());
        assertEquals("Nuestras tartas", productType.getDescription());
        assertEquals("TAR", productType.getCode());
    }
}
