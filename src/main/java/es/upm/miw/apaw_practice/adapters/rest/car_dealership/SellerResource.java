package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.Seller;
import es.upm.miw.apaw_practice.domain.services.car_dealership.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SellerResource.SELLERS)
public class SellerResource {

    static final String SELLERS ="/car-dealership/sellers";

    static final String ID_ID = "/{id}";

    static final String NAME = "/name";

    private final SellerService sellerService;

    @Autowired
    public SellerResource(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping
    public Seller create(@RequestBody Seller seller) {
        return this.sellerService.create(seller);
    }

    @PutMapping(ID_ID + NAME)
    public Seller updateSellerName(@PathVariable String id, @RequestBody String name) {
        return this.sellerService.updateSellerName(id, name);
    }

    @PatchMapping(ID_ID)
    public Seller updateSellerSurname(@PathVariable String id, @RequestBody String surname) {
        return this.sellerService.updateSellerSurname(id, surname);
    }
}
