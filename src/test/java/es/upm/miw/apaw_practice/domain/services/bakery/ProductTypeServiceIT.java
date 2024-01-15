package es.upm.miw.apaw_practice.domain.services.bakery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.bakery.ProductType;
import es.upm.miw.apaw_practice.domain.persistence_ports.bakery.ProductTypePersistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class ProductTypeServiceIT {

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductTypePersistence productTypePersistence;

    @Test
    void testFindByCode() {
        ProductType productType = this.productTypeService.findByCode("DULS");
        assertEquals(productType.getName(), this.productTypePersistence.findByCode("DULS").getName());
        assertEquals(productType.getDescription(), this.productTypePersistence.findByCode("DULS").getDescription());
    }
}
