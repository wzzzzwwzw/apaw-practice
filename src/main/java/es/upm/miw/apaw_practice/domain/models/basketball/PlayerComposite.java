package es.upm.miw.apaw_practice.domain.models.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.composite.TreePlayers;

import java.util.ArrayList;
import java.util.List;

public class PlayerComposite implements TreePlayers {
    private final String name;
    private final List<TreePlayers> treePlayersComponents;

    public PlayerComposite(String name) {
        this.name = name;
        this.treePlayersComponents = new ArrayList<>();
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreePlayers component) {
        this.treePlayersComponents.add(component);
    }

    @Override
    public void remove(TreePlayers component) {
        this.treePlayersComponents.remove(component);
    }

    public List<TreePlayers> getTreePlayerss() {
        return treePlayersComponents;
    }

    @Override
    public String toString() {
        return "PlayerComposite{" +
                "name='" + name + '\'' +
                ", treePlayersComponents=" + treePlayersComponents +
                '}';
    }
}
