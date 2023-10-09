package es.upm.miw.apaw_practice.adapters.mongodb.school;

import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.SubjectRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.SubjectEntity;
import es.upm.miw.apaw_practice.domain.models.school.Subject;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SchoolSeederService {

    @Autowired
    private SubjectRepository subjectRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- School Initial Load -----------");
        SubjectEntity[] subjects = {
                new SubjectEntity(new Subject("subject1", "desc1", true, 6)),
                new SubjectEntity(new Subject("subject2", "desc2", false, 5)),
                new SubjectEntity(new Subject("subject3", "desc3", false, 10)),
                new SubjectEntity(new Subject("subject4", "desc4", false, 1)),
                new SubjectEntity(new Subject("subject5", "desc5", true, 16))
        };
        this.subjectRepository.saveAll(Arrays.asList(subjects));
    }

    public void deleteAll() {
        this.subjectRepository.deleteAll();
    }
}
