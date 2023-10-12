package es.upm.miw.apaw_practice.adapters.rest.fruitshop;

import es.upm.miw.apaw_practice.domain.models.fruitShop.Customer;
import es.upm.miw.apaw_practice.domain.services.fruitshop.CustomerService;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CustomerResource.CUSTOMERS)
public class CustomerResource {
    static final String CUSTOMERS = "/fruitshop/customers";

    static final String ID_CUSTOMER = "/{idCustomer}";

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

   @GetMapping(ID_CUSTOMER)
    public Customer findById(@PathVariable Integer idCustomer){
        return this.customerService.findById(idCustomer);
   }

}
