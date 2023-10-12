package es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop;
import es.upm.miw.apaw_practice.domain.models.fruitShop.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPersistence {
    Customer findById(Integer idCustomer);
}
