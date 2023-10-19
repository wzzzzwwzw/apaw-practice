package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos.MedalRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos.CompetitorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.CompetitorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.MedalEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Medal;
import es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games.MedalPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("medalPersistence")
public class MedalPersistenceMongodb implements MedalPersistence {

    private final MedalRepository medalRepository;
    private final CompetitorRepository competitorRepository;

    @Autowired MedalPersistenceMongodb(MedalRepository medalRepository, CompetitorRepository competitorRepository) {
        this.medalRepository = medalRepository;
        this.competitorRepository = competitorRepository;
    }

    @Override
    public Medal readByMedalId(String id) {
        return this.medalRepository
                .findByMedalID(id)
                .orElseThrow(() -> new NotFoundException("Medal id: " + id))
                .toMedal();
    }

    @Override
    public Medal update(Medal medal) {
        MedalEntity medalEntity = this.medalRepository
                .findByMedalID(medal.getMedalID())
                .orElseThrow(() -> new NotFoundException("Medal id: " + medal.getMedalID()));
        CompetitorEntity competitorEntity = this.competitorRepository
                .findByName(medal.getWinner().getName())
                .orElseGet(() -> {
                    CompetitorEntity newCompetitor = new CompetitorEntity(medal.getWinner());
                    return this.competitorRepository.save(newCompetitor);
                });
        medalEntity.setTier(medalEntity.getTier());
        medalEntity.setTeamMedal(medalEntity.getTeamMedal());
        medalEntity.setWinner(competitorEntity);
        return this.medalRepository.save(medalEntity).toMedal();
    }

    @Override
    public List<String> findCompetitorsByCompetition (String competition) {
        return this.medalRepository
                .findAll()
                .stream()
                .filter(medal -> medal.getCompetition().equals(competition))
                .map(medal -> medal.getWinner().getName())
                .toList();
    }

    @Override
    public List<String> findTiersByCompetitor(List<String> competitorsNames) {
        return this.medalRepository
                .findAll()
                .stream()
                .filter(medal ->
                        competitorsNames.contains(medal.getWinner().getName()))
                .map(MedalEntity::getTier)
                .toList();
    }

}
