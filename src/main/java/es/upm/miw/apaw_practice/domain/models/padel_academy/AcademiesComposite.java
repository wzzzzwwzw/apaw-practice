package es.upm.miw.apaw_practice.domain.models.padel_academy;

import es.upm.miw.apaw_practice.domain.models.padel_academy.composite.TreeAcademies;

import java.util.ArrayList;
import java.util.List;

public class AcademiesComposite implements TreeAcademies {
    private final String academyId;
    private final List<TreeAcademies> treeAcademies;

    public AcademiesComposite(String academyId) {
        this.academyId = academyId;
        this.treeAcademies = new ArrayList<>();
    }

    public List<TreeAcademies> getTreeAcademies() {
        return treeAcademies;
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeAcademies treeAcademies) {
        this.treeAcademies.add(treeAcademies);
    }

    @Override
    public void remove(TreeAcademies treeAcademies) {
        this.treeAcademies.remove(treeAcademies);
    }

    @Override
    public String toString() {
        return "AcademiesComposite{" +
                "academyId='" + academyId + '\'' +
                ", treeAcademies=" + treeAcademies +
                '}';
    }
}
