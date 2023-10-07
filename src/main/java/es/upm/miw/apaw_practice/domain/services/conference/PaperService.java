package es.upm.miw.apaw_practice.domain.services.conference;

import es.upm.miw.apaw_practice.domain.models.conference.Paper;
import es.upm.miw.apaw_practice.domain.persistence_ports.conference.PaperPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperService {
    private final PaperPersistence paperPersistence;

    @Autowired
    public PaperService(PaperPersistence paperPersistence) {
        this.paperPersistence = paperPersistence;
    }

    public Paper read(String digitalObjectIdentifier) {
        return this.paperPersistence.readByDigitalObjectIdentifier(digitalObjectIdentifier);
    }
}
