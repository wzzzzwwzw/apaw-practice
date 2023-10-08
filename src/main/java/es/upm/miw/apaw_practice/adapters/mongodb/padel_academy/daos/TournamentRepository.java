package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities.TournamentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TournamentRepository extends MongoRepository<TournamentEntity, String> {
}
