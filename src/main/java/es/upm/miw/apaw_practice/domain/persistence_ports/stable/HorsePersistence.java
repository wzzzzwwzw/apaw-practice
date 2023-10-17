package es.upm.miw.apaw_practice.domain.persistence_ports.stable;

import es.upm.miw.apaw_practice.domain.models.stable.Horse;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Repository
public interface HorsePersistence {
    Stream<Horse> findByProviderAndPriceGreaterThan(BigDecimal purchasePrice);
}
