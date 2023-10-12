package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos.CustomerRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.fruitShop.Customer;
import es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop.CustomerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("customerPersistence")
public class CustomerPersistenceMongdb implements CustomerPersistence {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerPersistenceMongdb(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }


public Customer findById(Integer idCustomer){
    return this.customerRepository.findById(idCustomer)
            .orElseThrow(() -> new NotFoundException("Customer ID: " + idCustomer))
            .toCustomer();
    }
}
