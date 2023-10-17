package es.upm.miw.apaw_practice.domain.persistence_ports.stable;

import es.upm.miw.apaw_practice.domain.models.stable.Keeper;
import org.springframework.stereotype.Repository;

@Repository
public interface KeeperPersistence {
    Keeper create(Keeper keeper);
    boolean existName(String name);
}
