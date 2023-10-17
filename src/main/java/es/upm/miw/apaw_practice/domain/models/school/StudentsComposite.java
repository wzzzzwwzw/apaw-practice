package es.upm.miw.apaw_practice.domain.models.school;

import es.upm.miw.apaw_practice.domain.models.school.composite.TreeStudents;

import java.util.ArrayList;
import java.util.List;

public class StudentsComposite implements TreeStudents {
    private final String name;
    private final List<TreeStudents> treeStudents;

    public StudentsComposite(String name) {
        this.name = name;
        this.treeStudents = new ArrayList<>();
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeStudents treeStudents) {
        this.treeStudents.add(treeStudents);
    }

    @Override
    public void remove(TreeStudents treeStudents) {
        this.treeStudents.remove(treeStudents);
    }

    public List<TreeStudents> getTreeStudents() {
        return treeStudents;
    }

    @Override
    public String toString() {
        return "StudentsComposite{" +
                "name='" + name + '\'' +
                ", treeStudents=" + treeStudents +
                '}';
    }
}
