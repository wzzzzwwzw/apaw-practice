package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.domain.services.car_dealership.DealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DealershipResource.DEALERSHIPS)
public class DealershipResource {
    static final String DEALERSHIPS = "/car-dealership/dealerships";

    static final String ID_ID = "/{id}";
    private final DealershipService dealershipService;

    @Autowired
    public DealershipResource(DealershipService dealershipService) {
        this.dealershipService = dealershipService;
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.dealershipService.delete(id);
    }
}
