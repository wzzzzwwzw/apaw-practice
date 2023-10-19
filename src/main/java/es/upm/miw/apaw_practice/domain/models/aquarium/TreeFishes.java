package es.upm.miw.apaw_practice.domain.models.aquarium;

import es.upm.miw.apaw_practice.domain.models.aquarium.builders.FishBuilders;

public interface TreeFishes {
    Boolean isComposite();
    void add(TreeFishes treeFishes);
    void remove(TreeFishes treeFishes);


}
