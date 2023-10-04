package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
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
        return new CarToRepair(this.registrationNumber, this.brand, this.model, obdFaults);
    }

}
