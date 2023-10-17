package es.upm.miw.apaw_practice.domain.models.football_competition;

public interface TreeFootballPlayers {
    String name();

    boolean isComposite();

    void add(TreeFootballPlayers treeFootballPlayers);

    void remove(TreeFootballPlayers treeFootballPlayers);
}
