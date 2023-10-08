package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities.AgencyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AgencyRepository extends MongoRepository<AgencyEntity, String> {
    Optional<AgencyEntity> findByCompany(String company);
}
