package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos.FootballCompetitionRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballCompetitionEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballCompetition;
import es.upm.miw.apaw_practice.domain.persistence_ports.football_competition.FootballCompetitionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("footballCompetitionPersistence")
public class FootballCompetitionPersistenceMongodb implements FootballCompetitionPersistence {
    private final FootballCompetitionRepository footballCompetitionRepository;

    @Autowired
    public FootballCompetitionPersistenceMongodb(FootballCompetitionRepository footballCompetitionRepository) {
        this.footballCompetitionRepository = footballCompetitionRepository;
    }

    @Override
    public FootballCompetition readByOrganizingEntity(String organizingEntity) {
        return this.footballCompetitionRepository
                .findByOrganizingEntity(organizingEntity)
                .orElseThrow(() -> new NotFoundException("Football Competition Organizing Entity: " + organizingEntity))
                .toFootballCompetition();
    }

    @Override
    public void delete(String organizingEntity) {
        FootballCompetitionEntity footballCompetition = this.footballCompetitionRepository
                .findByOrganizingEntity(organizingEntity)
                .orElseThrow(() -> new NotFoundException("Football Competition Organizing Entity: " + organizingEntity));
        this.footballCompetitionRepository.delete(footballCompetition);
    }
}
