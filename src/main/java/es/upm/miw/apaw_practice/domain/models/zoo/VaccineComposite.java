package es.upm.miw.apaw_practice.domain.models.zoo;

import java.util.List;

public class VaccineComposite implements TreeVaccines{
    private final List<TreeVaccines> treeVaccinesList;
    private final String vaccinationScheduleName;

    public VaccineComposite(List<TreeVaccines> treeVaccinesList, String vaccinationScheduleName) {
        this.treeVaccinesList = treeVaccinesList;
        this.vaccinationScheduleName = vaccinationScheduleName;
    }


    @Override
    public void add(TreeVaccines treeVaccines) {
        this.treeVaccinesList.add(treeVaccines);
    }

    @Override
    public void remove(TreeVaccines treeVaccines) {
        this.treeVaccinesList.remove(treeVaccines);
    }

    @Override
    public String toString() {
        return "VaccineComposite{" +
                "treeVaccinesList=" + treeVaccinesList +
                ", vaccinationScheduleName='" + vaccinationScheduleName + '\'' +
                '}';
    }
}
