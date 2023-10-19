package es.upm.miw.apaw_practice.domain.models.climbing;

import es.upm.miw.apaw_practice.domain.models.climbing.composite.TreeAreas;

import java.util.ArrayList;
import java.util.List;

public class AreasComposite implements TreeAreas {
    private final String name;
    private final List<TreeAreas> treeAreas;

    public AreasComposite (String name) {
        this.name = name;
        this.treeAreas = new ArrayList<>();
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeAreas treeAreas) {
        this.treeAreas.add(treeAreas);
    }

    @Override
    public void remove(TreeAreas treeAreas) {
        this.treeAreas.remove(treeAreas);
    }

    public List<TreeAreas> getTreeAreas() {
        return treeAreas;
    }

    @Override
    public String toString() {
        return "AreasComposite{" +
                "name='" + name + '\'' +
                ", treeAreas=" + treeAreas +
                '}';
    }
}
