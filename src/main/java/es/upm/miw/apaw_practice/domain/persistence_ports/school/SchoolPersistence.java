package es.upm.miw.apaw_practice.domain.persistence_ports.school;

import es.upm.miw.apaw_practice.domain.models.school.School;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Repository
public interface SchoolPersistence {

    School read(String name);

    BigDecimal registrationPriceSumGivenBilingual(Boolean bilingual);
}
