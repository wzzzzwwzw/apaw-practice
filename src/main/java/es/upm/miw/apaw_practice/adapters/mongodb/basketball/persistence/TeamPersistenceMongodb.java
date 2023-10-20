package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.TeamBasketballRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.PavilionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.PlayerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.TeamBasketballEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.basketball.Team;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.TeamPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("teamPersistenceBasketball")
public class TeamPersistenceMongodb implements TeamPersistence {
    private final TeamBasketballRepository teamBasketballRepository;

    @Autowired
    public TeamPersistenceMongodb(TeamBasketballRepository teamBasketballRepository) {
        this.teamBasketballRepository = teamBasketballRepository;
    }

    @Override
    public Team update(Team team) {
        TeamBasketballEntity teamEntity = this.teamBasketballRepository
                .findByAlias(team.getAlias())
                .orElseThrow(() -> new NotFoundException("Team alias:" + team.getAlias()));
        List<PlayerEntity> playerEntities = team.getPlayers().stream()
                .map(player -> new PlayerEntity(
                        player.getEmail(),
                        player.getPosition(),
                        player.getAge()
                )).toList();

        List<PavilionEntity> pavilionEntities = team.getPavilions().stream()
                .map(PavilionEntity::new).toList();

        teamEntity.setPlayerEntities(playerEntities);
        teamEntity.setPavilionEntities(pavilionEntities);
        return this.teamBasketballRepository
                .save(teamEntity)
                .toTeam();
    }

    @Override
    public Team readByAlias(String alias) {
        return this.teamBasketballRepository.findByAlias(alias)
                .orElseThrow(() -> new NotFoundException("Team alias: " + alias))
                .toTeam();
    }

}
