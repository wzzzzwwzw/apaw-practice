package es.upm.miw.apaw_practice.domain.models.zoo;

import java.time.LocalDate;

public class Vaccine implements TreeVaccines {

    private String identifierBatch;
    private String name;
    private LocalDate manufacturingDate;

    public Vaccine() {
        //empty for framework
    }

    public Vaccine(String identifierBatch, String name, LocalDate manufacturingDate) {
        this.identifierBatch = identifierBatch;
        this.name = name;
        this.manufacturingDate = manufacturingDate;
    }

    public String getIdentifierBatch() {
        return identifierBatch;
    }

    public void setIdentifierBatch(String identifierBatch) {
        this.identifierBatch = identifierBatch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "identifiedLot='" + identifierBatch + '\'' +
                ", name='" + name + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                '}';
    }

    @Override
    public void add(TreeVaccines treeVaccines) {
        throw new UnsupportedOperationException("Unsupported operation in leaf");
    }

    @Override
    public void remove(TreeVaccines treeVaccines) {

    }
}
