package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.daos.TournamentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities.TournamentEntity;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Tournament;
import es.upm.miw.apaw_practice.domain.persistence_ports.padel_academy.TournamentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("tournamentPersistence")
public class TournamentPersistenceMongodb implements TournamentPersistence {
    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentPersistenceMongodb(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public Tournament create(Tournament tournament) {
        return this.tournamentRepository
                .save(new TournamentEntity(tournament))
                .toTournament();
    }

    @Override
    public Stream<Tournament> readAll() {
        return this.tournamentRepository.findAll()
                .stream()
                .map(TournamentEntity::toTournament);
    }
}
