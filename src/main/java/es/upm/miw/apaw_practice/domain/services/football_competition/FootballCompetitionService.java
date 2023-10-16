package es.upm.miw.apaw_practice.domain.services.football_competition;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballCompetition;
import es.upm.miw.apaw_practice.domain.persistence_ports.football_competition.FootballCompetitionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootballCompetitionService {
    private final FootballCompetitionPersistence footballCompetitionPersistence;

    @Autowired
    public FootballCompetitionService(FootballCompetitionPersistence footballCompetitionPersistence) {
        this.footballCompetitionPersistence = footballCompetitionPersistence;
    }

    public void delete(String organizingEntity) {
        this.footballCompetitionPersistence.delete(organizingEntity);
    }

    public FootballCompetition getFootballCompetitionByOrganizingEntity(String organizingEntity) {
        return this.footballCompetitionPersistence.readByOrganizingEntity(organizingEntity);
    }
}
