package es.upm.miw.apaw_practice.domain.models.subway.trees;

public interface TreeLines {
    Boolean isComposite();

    void add(TreeLines treeLines);

    void remove(TreeLines treeLines);
}
