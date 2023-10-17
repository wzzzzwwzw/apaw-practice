package es.upm.miw.apaw_practice.domain.models.football_competition;

public class TreeFootballPlayersLeaf implements TreeFootballPlayers {
    private final FootballPlayer player;

    public TreeFootballPlayersLeaf(FootballPlayer player) {
        this.player = player;
    }

    @Override
    public String name() {
        return this.player.getName();
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeFootballPlayers treeFootballPlayers) {
        // Do nothing because it is a leaf
    }

    @Override
    public void remove(TreeFootballPlayers treeFootballPlayers) {
        // Do nothing because it is a leaf
    }
}
