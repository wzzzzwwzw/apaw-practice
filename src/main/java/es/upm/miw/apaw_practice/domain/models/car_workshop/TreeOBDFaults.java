package es.upm.miw.apaw_practice.domain.models.car_workshop;

public interface TreeOBDFaults {

    String family();

    boolean isComposite();

    void add(TreeOBDFaults treeOBDFaults);

    void remove(TreeOBDFaults treeOBDFaults);
}
