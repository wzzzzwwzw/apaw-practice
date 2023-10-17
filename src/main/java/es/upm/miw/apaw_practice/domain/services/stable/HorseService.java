package es.upm.miw.apaw_practice.domain.services.stable;

import es.upm.miw.apaw_practice.domain.models.stable.Horse;
import es.upm.miw.apaw_practice.domain.persistence_ports.stable.HorsePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Service
public class HorseService {
    private final HorsePersistence horsePersistence;
    @Autowired
    public HorseService(HorsePersistence horsePersistence) {
        this.horsePersistence = horsePersistence;
    }

    public Stream<Horse> findByProviderAndPriceGreaterThan(BigDecimal purchasePrice) {
        return this.horsePersistence.findByProviderAndPriceGreaterThan(purchasePrice);
    }
}
