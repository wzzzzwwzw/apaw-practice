package es.upm.miw.apaw_practice.domain.models.school.composite;

public interface TreeStudents {
    Boolean isComposite();

    void add(TreeStudents treeStudents);

    void remove(TreeStudents treeStudents);
}
