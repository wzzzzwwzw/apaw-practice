package es.upm.miw.apaw_practice.domain.models.subway;

import es.upm.miw.apaw_practice.domain.models.subway.trees.TreeLines;

import java.util.ArrayList;
import java.util.List;

public class LineComposite implements TreeLines {
    private final String label;
    private final List<TreeLines> treeLines;

    public LineComposite(String label) {
        this.label = label;
        this.treeLines = new ArrayList<>();
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeLines treeLines) {
        this.treeLines.add(treeLines);
    }

    @Override
    public void remove(TreeLines treeLines) {
        this.treeLines.remove(treeLines);
    }

    public List<TreeLines> getTreeLines() {
        return treeLines;
    }

    @Override
    public String toString() {
        return "LineComposite{" +
                "label='" + label + '\'' +
                ", treeLines=" + treeLines +
                '}';
    }
}

