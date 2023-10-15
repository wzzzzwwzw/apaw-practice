package es.upm.miw.apaw_practice.adapters.mongodb.climbing.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.climbing.daos.ExpeditionRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities.ExpeditionEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.climbing.Expedition;
import es.upm.miw.apaw_practice.domain.persistence_ports.climbing.ExpeditionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("expeditionPersistence")
public class ExpeditionPersistenceMongodb implements ExpeditionPersistence {

    private final ExpeditionRepository expeditionRepository;

    @Autowired
    public ExpeditionPersistenceMongodb(ExpeditionRepository expeditionRepository) {
        this.expeditionRepository = expeditionRepository;
    }

    @Override
    public Expedition create(Expedition expedition) {
        return this.expeditionRepository
                .save(new ExpeditionEntity(expedition))
                .toExpedition();
    }
}
