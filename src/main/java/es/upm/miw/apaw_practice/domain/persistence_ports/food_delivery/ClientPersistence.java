package es.upm.miw.apaw_practice.domain.persistence_ports.food_delivery;


import org.springframework.stereotype.Repository;

@Repository
public interface ClientPersistence {

    void delete(String identity);
}
