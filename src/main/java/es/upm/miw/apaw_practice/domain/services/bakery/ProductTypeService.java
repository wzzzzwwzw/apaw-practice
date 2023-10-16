package es.upm.miw.apaw_practice.domain.services.bakery;

import es.upm.miw.apaw_practice.domain.models.bakery.ProductType;
import es.upm.miw.apaw_practice.domain.persistence_ports.bakery.ProductTypePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService {

    private final ProductTypePersistence productTypePersistence;

    @Autowired
    public ProductTypeService(ProductTypePersistence productTypePersistence) {
        this.productTypePersistence = productTypePersistence;
    }

    public ProductType findByCode(String code) {
        return this.productTypePersistence.findByCode(code);
    }

}