package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos.FootballCompetitionRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos.FootballPlayerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballCompetitionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballPlayerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballCompetition;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballPlayer;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballTeam;
import es.upm.miw.apaw_practice.domain.persistence_ports.football_competition.FootballCompetitionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("footballCompetitionPersistence")
public class FootballCompetitionPersistenceMongodb implements FootballCompetitionPersistence {
    private final FootballCompetitionRepository footballCompetitionRepository;
    private final FootballPlayerRepository footballPlayerRepository;

    @Autowired
    public FootballCompetitionPersistenceMongodb(FootballCompetitionRepository footballCompetitionRepository,
                                                 FootballPlayerRepository footballPlayerRepository) {
        this.footballCompetitionRepository = footballCompetitionRepository;
        this.footballPlayerRepository = footballPlayerRepository;
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

    @Override
    public List<String> getNamesByOrganizingEntity(String organizingEntity) {
        List<FootballTeam> teams = this.readByOrganizingEntity(organizingEntity).getTeams();

        return this.footballPlayerRepository.findAll().stream()
                .map(FootballPlayerEntity::toFootballPlayer)
                .filter(player -> teams.stream()
                        .map(FootballTeam::getCity).toList()
                        .contains(player.getTeam().getCity())).distinct()
                .map(FootballPlayer::getName).toList();
    }
}
