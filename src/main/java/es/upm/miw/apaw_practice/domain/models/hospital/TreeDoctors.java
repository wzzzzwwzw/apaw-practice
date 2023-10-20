package es.upm.miw.apaw_practice.domain.models.hospital;

public interface TreeDoctors {
    Boolean isComposite();

    void add(TreeDoctors treeDoctors);

    void remove(TreeDoctors treeDoctors);
}
