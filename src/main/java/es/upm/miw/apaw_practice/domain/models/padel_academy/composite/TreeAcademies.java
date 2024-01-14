package es.upm.miw.apaw_practice.domain.models.padel_academy.composite;

public interface TreeAcademies {
    Boolean isComposite();
    void add(TreeAcademies treeAcademies);
    void remove(TreeAcademies treeAcademies);
}
