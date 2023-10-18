package es.upm.miw.apaw_practice.domain.models.airport;

public interface TreePassengers {
    Boolean isComposite();
    void add(TreePassengers treePassengers);
    void remove(TreePassengers treePassengers);
}
