package es.upm.miw.apaw_practice.domain.models.car_workshop;

import java.util.ArrayList;
import java.util.List;

public class OBDFaultComposite implements TreeOBDFaults {

    private final String family;

    private final List<TreeOBDFaults> treeOBDFaultsList;

    public OBDFaultComposite(String family, List<TreeOBDFaults> treeOBDFaultsList) {
        this.family = family;
        this.treeOBDFaultsList = treeOBDFaultsList;
    }

    public OBDFaultComposite(String family) {
        this.family = family;
        this.treeOBDFaultsList = new ArrayList<>();
    }

    @Override
    public String family() {
        return this.family;
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeOBDFaults treeOBDFaults) {
        this.treeOBDFaultsList.add(treeOBDFaults);
    }

    @Override
    public void remove(TreeOBDFaults treeOBDFaults) {
        this.treeOBDFaultsList.remove(treeOBDFaults);
    }
}
