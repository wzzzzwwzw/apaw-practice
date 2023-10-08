package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities.VideogameCompanyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VideogameCompanyRepository extends MongoRepository <VideogameCompanyEntity, String>{
    Optional<VideogameCompanyEntity> findByName(String name);
}
