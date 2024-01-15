package es.upm.miw.apaw_practice.domain.services.school;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.school.School;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.SchoolPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SchoolService {

    private final SchoolPersistence schoolPersistence;

    @Autowired
    public SchoolService(SchoolPersistence schoolPersistence) {
        this.schoolPersistence = schoolPersistence;
    }

    public School read(String name) {
        return this.schoolPersistence.read(name);
    }
    public BigDecimal registrationPriceSumGivenBilingual(Boolean bilingual) {
        return this.schoolPersistence.registrationPriceSumGivenBilingual(bilingual);
    }
}
