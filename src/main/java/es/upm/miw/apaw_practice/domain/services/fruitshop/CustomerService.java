package es.upm.miw.apaw_practice.domain.services.fruitshop;

import es.upm.miw.apaw_practice.domain.models.fruitShop.Customer;
import es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop.CustomerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerPersistence customerPersistence;

    @Autowired
    public CustomerService(CustomerPersistence customerPersistence){
        this.customerPersistence = customerPersistence;
    }

    public Customer findByIdCustomer(Integer idCustomer){
        return this.customerPersistence.findByIdCustomer(idCustomer);
    }

}
