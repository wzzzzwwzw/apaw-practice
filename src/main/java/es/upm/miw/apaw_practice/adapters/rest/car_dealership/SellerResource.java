package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.Seller;
import es.upm.miw.apaw_practice.domain.services.car_dealership.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SellerResource.SELLERS)
public class SellerResource {

    static final String SELLERS ="/car-dealership/sellers";

    private final SellerService sellerService;

    @Autowired
    public SellerResource(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping
    public Seller create(@RequestBody Seller seller) {
        return this.sellerService.create(seller);
    }
}
