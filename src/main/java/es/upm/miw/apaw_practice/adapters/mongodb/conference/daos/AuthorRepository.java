package es.upm.miw.apaw_practice.adapters.mongodb.conference.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.conference.entities.AuthorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<AuthorEntity, String> {
}
