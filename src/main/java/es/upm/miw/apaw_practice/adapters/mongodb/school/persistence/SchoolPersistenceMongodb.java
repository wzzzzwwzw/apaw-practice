package es.upm.miw.apaw_practice.adapters.mongodb.school.persistence;

import es.upm.miw.apaw_practice.domain.models.school.School;
import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.SchoolRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.SchoolEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.SchoolPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Repository("SchoolPersistence")
public class SchoolPersistenceMongodb implements SchoolPersistence {
    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolPersistenceMongodb(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public School read(String name) {
        return this.schoolRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("School location: " + name))
                .toSchool();
    }

    @Override
    public BigDecimal registrationPriceSumGivenBilingual(Boolean bilingual) {
        return this.schoolRepository
                    .findAll().stream()
                        .filter(school -> school.getStudents().stream()
                            .allMatch(studentEntity -> studentEntity.toStudent().getSubjects().stream()
                                .allMatch(subject -> subject.getBilingual().equals(bilingual)
                                )
                            )
                        )
                        .map(SchoolEntity::toSchool)
                        .map(School::getRegistrationPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
