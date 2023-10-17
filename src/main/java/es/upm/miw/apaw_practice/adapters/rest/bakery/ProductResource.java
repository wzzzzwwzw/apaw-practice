package es.upm.miw.apaw_practice.adapters.rest.bakery;

import es.upm.miw.apaw_practice.domain.models.bakery.Product;
import es.upm.miw.apaw_practice.domain.services.bakery.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ProductResource.PRODUCTS)
public class ProductResource {
    static final String PRODUCTS = "/bakery/products";
    static final String NAME_ID = "/{name}";

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @DeleteMapping(NAME_ID)
    public void delete(@PathVariable String name) {
        this.productService.delete(name);
    }

    @PatchMapping(NAME_ID)
    public Product updatePrice(@PathVariable String name, @RequestBody String price) {
        return this.productService.updatePrice(name, price);
    }
}