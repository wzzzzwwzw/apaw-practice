package es.upm.miw.apaw_practice.domain.persistence_ports.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Pavilion;
import org.springframework.stereotype.Repository;

@Repository
public interface PavilionPersistence {
    Pavilion readByPavname(String pavname);
}
