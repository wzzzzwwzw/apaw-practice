package es.upm.miw.apaw_practice.domain.models.football_competition;

import java.util.ArrayList;
import java.util.List;

public class TreeFootballPlayersComposite implements TreeFootballPlayers {
    private final String name;
    private final List<TreeFootballPlayers> treeFootballPlayersList;

    public TreeFootballPlayersComposite(String name) {
        this.name = name;
        this.treeFootballPlayersList = new ArrayList<>();
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeFootballPlayers treeFootballPlayers) {
        this.treeFootballPlayersList.add(treeFootballPlayers);
    }

    @Override
    public void remove(TreeFootballPlayers treeFootballPlayers) {
        this.treeFootballPlayersList.remove(treeFootballPlayers);
    }

    public List<TreeFootballPlayers> getTreeFootballPlayers() {
        return this.treeFootballPlayersList;
    }

    @Override
    public String toString() {
        return "TreeFootballPlayersComposite{" +
                "treeFootballPlayersList=" + this.treeFootballPlayersList +
                ", name=" + this.name +
                '}';
    }
}
