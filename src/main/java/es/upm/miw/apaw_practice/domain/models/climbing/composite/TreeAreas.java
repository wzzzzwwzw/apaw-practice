package es.upm.miw.apaw_practice.domain.models.climbing.composite;

public interface TreeAreas {
    Boolean isComposite();

    void add(TreeAreas treeAreas);

    void remove(TreeAreas treeAreas);
}
