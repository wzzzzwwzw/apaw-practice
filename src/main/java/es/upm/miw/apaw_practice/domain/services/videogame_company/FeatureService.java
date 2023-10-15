package es.upm.miw.apaw_practice.domain.services.videogame_company;

import es.upm.miw.apaw_practice.domain.models.videogame_company.Feature;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company.FeaturePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureService {
    private final FeaturePersistence featurePersistence;

    @Autowired
    public FeatureService(FeaturePersistence featurePersistence){
        this.featurePersistence = featurePersistence;
    }

    public Feature updateCloudSynchronization(String genre, Boolean cloudSynchronization){
        Feature feature = this.featurePersistence.readByGenre(genre);
        feature.setCloudSynchronization(cloudSynchronization);
        return this.featurePersistence.updateCloudSynchronization(feature);
    }
}
