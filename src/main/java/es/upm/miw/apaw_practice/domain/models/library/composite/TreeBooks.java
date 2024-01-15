package es.upm.miw.apaw_practice.domain.models.library.composite;

public interface TreeBooks {
    Boolean isComposite();
    void add(TreeBooks treeBooks);
    void remove(TreeBooks treeBooks);
    int number();
}
