package es.upm.miw.apaw_practice.domain.persistence_ports.formula_one;

import org.springframework.stereotype.Repository;

@Repository
public interface TeamPersistence {
    void delete(String teamName);
}
