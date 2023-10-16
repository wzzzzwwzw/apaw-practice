package es.upm.miw.apaw_practice.adapters.mongodb.school.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.SubjectRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.SubjectEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.school.Subject;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.SubjectPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("SubjectPersistence")

public class SubjectPersistenceMongodb implements SubjectPersistence {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectPersistenceMongodb(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject read(String title) {
        return this.subjectRepository
                .findByTitle(title)
                .orElseThrow(() -> new NotFoundException("Subject location: " + title))
                .toSubject();
    }

    @Override
    public boolean existTitle(String title) {
        return this.subjectRepository
                .findByTitle(title)
                .isPresent();
    }

    @Override
    public Stream<Subject> readAll() {
        return this.subjectRepository
                .findAll().stream()
                .map(SubjectEntity::toSubject);
    }

    @Override
    public Subject create(Subject subject) {
        return this.subjectRepository
                .save(new SubjectEntity(subject))
                .toSubject();
    }

    @Override
    public void delete(String title) {
        SubjectEntity subjectEntity = this.subjectRepository
                .findByTitle(title)
                .orElseThrow(() -> new NotFoundException("Subject title: " + title));
        this.subjectRepository
            .delete(subjectEntity);
    }
}
