package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities.BrandEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BrandRepository extends MongoRepository<BrandEntity, String> {
    Optional<BrandEntity> findByTrademark(String trademark);
    Optional<BrandEntity> findByAgencyId(String campaignId);
}
