package es.upm.miw.apaw_practice.adapters.rest.bakery;

import es.upm.miw.apaw_practice.domain.models.bakery.ProductType;
import es.upm.miw.apaw_practice.domain.services.bakery.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ProductTypeResource.PRODUCT_TYPES)
public class ProductTypeResource {
    static final String PRODUCT_TYPES = "/bakery/product-types";
    static final String CODE_ID = "/{code}";

    private final ProductTypeService productTypeService;

    @Autowired
    public ProductTypeResource(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping(CODE_ID)
    public ProductType read(@PathVariable String code) {
        return this.productTypeService.findByCode(code);
    } 
}