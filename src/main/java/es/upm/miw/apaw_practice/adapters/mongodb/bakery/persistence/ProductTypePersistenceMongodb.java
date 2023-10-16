package es.upm.miw.apaw_practice.adapters.mongodb.bakery.persistence;

import es.upm.miw.apaw_practice.domain.models.bakery.ProductType;
import es.upm.miw.apaw_practice.adapters.mongodb.bakery.daos.ProductTypeRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.bakery.ProductTypePersistence;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("productTypePersistence")
public class ProductTypePersistenceMongodb implements ProductTypePersistence {
    
    private final ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductTypePersistenceMongodb(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public ProductType findByCode(String code) {
        return this.productTypeRepository.findAll().stream()
                .filter(productType -> code.equals(productType.getCode()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Product Type with code " + code + " not found."))
                .toProductType();
    }
}
