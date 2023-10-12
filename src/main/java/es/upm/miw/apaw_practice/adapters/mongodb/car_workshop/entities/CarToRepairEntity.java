package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import es.upm.miw.apaw_practice.domain.models.car_workshop.CarToRepair;
import es.upm.miw.apaw_practice.domain.models.car_workshop.OBDFault;

@Document
public class CarToRepairEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String registrationNumber;
    private String brand;
    private String model;
    @DBRef
    private List<OBDFaultEntity> obdFaultEntities;

    public CarToRepairEntity() {
        // empty for framework
    }

    public CarToRepairEntity(String registrationNumber, String brand, String model,
            List<OBDFaultEntity> obdFaultEntities) {
        this.id = UUID.randomUUID().toString();
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.obdFaultEntities = obdFaultEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<OBDFaultEntity> getObdFaultEntities() {
        return obdFaultEntities;
    }

    public void setObdFaultEntities(List<OBDFaultEntity> obdFaultEntities) {
        this.obdFaultEntities = obdFaultEntities;
    }

    public CarToRepair toCarToRepair() {
        List<OBDFault> obdFaults = this.obdFaultEntities.stream()
                .map(OBDFaultEntity::toOBDFault)
                .toList();
        return new CarToRepair(this.registrationNumber, this.model, this.brand, obdFaults);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((registrationNumber == null) ? 0 : registrationNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CarToRepairEntity other = (CarToRepairEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (registrationNumber == null) {
            if (other.registrationNumber != null)
                return false;
        } else if (!registrationNumber.equals(other.registrationNumber))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CarToRepairEntity [id=" + id + ", registrationNumber=" + registrationNumber + ", brand=" + brand
                + ", model=" + model + ", obdFaultEntities=" + obdFaultEntities + "]";
    }

}
