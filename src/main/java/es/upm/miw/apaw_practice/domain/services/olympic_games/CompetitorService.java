package es.upm.miw.apaw_practice.domain.services.olympic_games;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games.CompetitorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitorService {
    private final CompetitorPersistence competitorPersistence;

    @Autowired
    public CompetitorService(CompetitorPersistence competitorPersistence) {
        this.competitorPersistence = competitorPersistence;
    }

    public Competitor create(Competitor competitor) {
        this.assertNameNotExist(competitor.getName());
        return this.competitorPersistence.create(competitor);
    }

    private void assertNameNotExist(String name) {
        if (this.competitorPersistence.existName(name)) {
            throw new ConflictException("Competitor name exist: " + name);
        }
    }
}
