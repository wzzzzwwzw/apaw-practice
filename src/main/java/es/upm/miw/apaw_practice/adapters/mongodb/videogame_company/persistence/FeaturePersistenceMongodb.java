package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos.FeatureRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities.FeatureEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.videogame_company.Feature;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company.FeaturePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("featurePersistence")
public class FeaturePersistenceMongodb implements FeaturePersistence {
    private final FeatureRepository featureRepository;

    @Autowired
    public FeaturePersistenceMongodb(FeatureRepository featureRepository){
        this.featureRepository = featureRepository;
    }

    @Override
    public Feature updateCloudSynchronization(Feature feature){
        FeatureEntity featureEntity = this.featureRepository
                .findByGenre(feature.getGenre())
                .orElseThrow(() -> new NotFoundException("Feature Genre: " + feature.getGenre()));
        featureEntity.setCloudSynchronization(feature.getCloudSynchronization());
        return this.featureRepository.save(featureEntity).toFeature();
    }


    public Feature readByGenre(String genre){
        return this.featureRepository
                .findByGenre(genre)
                .orElseThrow(() -> new NotFoundException("Feature Genre: " + genre))
                .toFeature();
    }


}
