package es.upm.miw.apaw_practice.domain.models.basketball.composite;

public interface TreePlayers {
    Boolean isComposite();

    void add(TreePlayers component);

    void remove(TreePlayers component);
}
