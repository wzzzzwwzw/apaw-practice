package es.upm.miw.apaw_practice.domain.persistence_ports.aquarium;
import org.springframework.stereotype.Repository;

@Repository
public interface FishpondPersistence {
    void delete(String direction);
}

