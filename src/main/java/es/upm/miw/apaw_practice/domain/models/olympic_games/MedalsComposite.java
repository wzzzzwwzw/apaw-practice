package es.upm.miw.apaw_practice.domain.models.olympic_games;

import es.upm.miw.apaw_practice.domain.models.olympic_games.composite.TreeMedals;

import java.util.ArrayList;
import java.util.List;

public class MedalsComposite implements TreeMedals {

    private final String medalID;
    private final List<TreeMedals> treeMedals;

    public MedalsComposite(String medalID) {
        this.medalID = medalID;
        this.treeMedals = new ArrayList<>();
    }

    public List<TreeMedals> getTreeMedals() {
        return treeMedals;
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeMedals treeMedals) {
        this.treeMedals.add(treeMedals);
    }

    @Override
    public void remove(TreeMedals treeMedals) {
        this.treeMedals.remove(treeMedals);
    }

    @Override
    public String toString() {
        return "MedalsComposite{" +
                "medalID='" + medalID + '\'' +
                ", treeMedals=" + treeMedals +
                '}';
    }

}
