package es.upm.miw.apaw_practice.domain.models.aquarium;

public interface TreeFishes {
    Boolean isComposite();
    void add(TreeFishes treeFishes);
    void remove(TreeFishes treeFishes);
}
