package es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities;

import es.upm.miw.apaw_practice.domain.models.zoo.Vaccine;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document
public class VaccineEntity {


    @Id
    private String id;
    private String identifierBatch;
    private String name;
    private LocalDate manufacturingDate;

    public VaccineEntity() {
        //empty for framework
    }

    public VaccineEntity(Vaccine vaccine) {
        BeanUtils.copyProperties(vaccine, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Vaccine toVaccine() {
        Vaccine vaccine = new Vaccine();
        BeanUtils.copyProperties(this, vaccine);
        return vaccine;
    }

    @Override
    public boolean equals(Object obj) {
        VaccineEntity objAux = (VaccineEntity) obj;
        return this == obj || obj != null && getClass() == obj.getClass() && (this.identifierBatch.equals(objAux.getIdentifierBatch()));
    }

    @Override
    public String toString() {
        return "VaccineEntity{" +
                "id='" + id + '\'' +
                ", identifierBatch='" + identifierBatch + '\'' +
                ", name='" + name + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                '}';
    }
}
