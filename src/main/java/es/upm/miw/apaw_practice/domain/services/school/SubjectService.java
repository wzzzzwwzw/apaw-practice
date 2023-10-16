package es.upm.miw.apaw_practice.domain.services.school;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.school.Subject;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.SubjectPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    private final SubjectPersistence subjectPersistence;

    @Autowired
    public SubjectService(SubjectPersistence subjectPersistence) {
        this.subjectPersistence = subjectPersistence;
    }

    public void assertTitleNotExist(String title) {
        if (this.subjectPersistence.existTitle(title)) {
            throw new ConflictException("Title does not exist: " + title);
        }
    }

    public Subject create(Subject subject) {
        this.assertTitleNotExist(subject.getTitle());
        return this.subjectPersistence.create(subject);
    }

    public Subject read(String title) {
        return this.subjectPersistence.read(title);
    }

    public void delete(String title) {
        this.subjectPersistence.delete(title);
    }
}
