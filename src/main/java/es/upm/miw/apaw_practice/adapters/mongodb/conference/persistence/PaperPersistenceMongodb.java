package es.upm.miw.apaw_practice.adapters.mongodb.conference.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.conference.daos.PaperRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.entities.PaperEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.conference.Paper;
import es.upm.miw.apaw_practice.domain.persistence_ports.conference.PaperPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("paperPersistence")
public class PaperPersistenceMongodb implements PaperPersistence {
    private final PaperRepository paperRepository;

    @Autowired
    public PaperPersistenceMongodb(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    @Override
    public Paper readByDigitalObjectIdentifier(String digitalObjectIdentifier) {
        return this.paperRepository.findByDigitalObjectIdentifier(digitalObjectIdentifier)
                .orElseThrow(() -> new NotFoundException("Paper digitalObjectIdentifier: " + digitalObjectIdentifier))
                .toPaper();
    }

    @Override
    public Paper update(Paper paper) {
        PaperEntity paperEntity = this.paperRepository
                .findByDigitalObjectIdentifier(paper.getDigitalObjectIdentifier())
                .orElseThrow(() -> new NotFoundException("Paper digitalObjectIdentifier:" + paper.getDigitalObjectIdentifier()));
        paperEntity.setTitle(paper.getTitle());
        return this.paperRepository.save(paperEntity).toPaper();
    }
}
