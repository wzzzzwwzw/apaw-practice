package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities;

import es.upm.miw.apaw_practice.domain.models.formula_one.EngineManufacturer;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class EngineManufacturerEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String manufacturerName;
    private String engineBuiltIn;
    private Integer numberOfEnginesSupplied;

    public EngineManufacturerEntity() {
        //empty for framework
    }

    public EngineManufacturerEntity(String manufacturerName, String engineBuiltIn, Integer numberOfEnginesSupplied) {
        this.id = UUID.randomUUID().toString();
        this.manufacturerName = manufacturerName;
        this.engineBuiltIn = engineBuiltIn;
        this.numberOfEnginesSupplied = numberOfEnginesSupplied;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getEngineBuiltIn() {
        return engineBuiltIn;
    }

    public void setEngineBuiltIn(String engineBuiltIn) {
        this.engineBuiltIn = engineBuiltIn;
    }

    public Integer getNumberOfEnginesSupplied() {
        return numberOfEnginesSupplied;
    }

    public void setNumberOfEnginesSupplied(Integer numberOfEnginesSupplied) {
        this.numberOfEnginesSupplied = numberOfEnginesSupplied;
    }

    public EngineManufacturer toEngineManufacturer() {
        EngineManufacturer engineManufacturer = new EngineManufacturer();
        BeanUtils.copyProperties(this, engineManufacturer);
        return engineManufacturer;
    }

    @Override
    public String toString() {
        return "EngineManufacturerEntity{" +
                "id='" + id + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", engineBuiltIn='" + engineBuiltIn + '\'' +
                ", numberOfEnginesSupplied=" + numberOfEnginesSupplied +
                '}';
    }
}
