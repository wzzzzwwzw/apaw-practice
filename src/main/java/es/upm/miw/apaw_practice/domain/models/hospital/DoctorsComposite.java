package es.upm.miw.apaw_practice.domain.models.hospital;

import java.util.ArrayList;
import java.util.List;

public class DoctorsComposite implements  TreeDoctors {
    private final String medicalLicenseCode;
    private final List<TreeDoctors> treeDoctors;

    public DoctorsComposite(String medicalLicenseCode) {
        this.medicalLicenseCode = medicalLicenseCode;
        this.treeDoctors = new ArrayList<>();
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeDoctors treeDoctors) {
        this.treeDoctors.add(treeDoctors);
    }

    @Override
    public void remove(TreeDoctors treeDoctors) {
        this.treeDoctors.remove(treeDoctors);
    }
    public List<TreeDoctors> getTreeDoctors(){
        return this.treeDoctors;
    }

    @Override
    public String toString() {
        return "DoctorsComposite{" +
                "medicalLicenseCode='" + medicalLicenseCode + '\'' +
                ", treeDoctors=" + treeDoctors +
                '}';
    }
}
