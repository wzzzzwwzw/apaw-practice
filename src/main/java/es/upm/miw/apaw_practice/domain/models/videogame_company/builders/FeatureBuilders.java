package es.upm.miw.apaw_practice.domain.models.videogame_company.builders;

import es.upm.miw.apaw_practice.domain.models.videogame_company.Feature;

public interface FeatureBuilders {
    interface Genre{
        GameStyle genre(String genre);
    }

    interface GameStyle{
        CloudSynchronization gameStyle(String gameStyle);
    }

    interface CloudSynchronization{
        Build cloudSynchronization(Boolean cloudSynchronization);
    }

    interface Build{
        Feature build();
    }
}
