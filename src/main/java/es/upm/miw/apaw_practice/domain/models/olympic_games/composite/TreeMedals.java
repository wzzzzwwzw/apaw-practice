package es.upm.miw.apaw_practice.domain.models.olympic_games.composite;

public interface TreeMedals {

    Boolean isComposite();

    void add(TreeMedals treeMedals);

    void remove(TreeMedals treeMedals);
}
