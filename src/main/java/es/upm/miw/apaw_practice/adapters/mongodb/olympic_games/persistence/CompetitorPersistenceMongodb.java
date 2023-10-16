package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos.CompetitorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.CompetitorEntity;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games.CompetitorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("competitorPersistence")
public class CompetitorPersistenceMongodb implements CompetitorPersistence {
    private final CompetitorRepository competitorRepository;

    @Autowired
    public CompetitorPersistenceMongodb (CompetitorRepository competitorRepository) {
        this.competitorRepository = competitorRepository;
    }

    @Override
    public Competitor create(Competitor competitor) {
        return this.competitorRepository
                .save(new CompetitorEntity(competitor))
                .toCompetitor();
    }

    @Override
    public boolean existName(String name) {
        return this.competitorRepository
                .findByName(name)
                .isPresent();
    }
}
