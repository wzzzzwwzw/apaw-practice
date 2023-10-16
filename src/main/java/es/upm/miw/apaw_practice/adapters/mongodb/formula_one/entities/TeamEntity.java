package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class TeamEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String teamName;
    private String country;
    @DBRef
    private List<DriverEntity> driverEntities;
    @DBRef
    private EngineManufacturerEntity engineManufacturerEntity;
    private String mainColor;

    public TeamEntity() {
        //empty for framework
    }

    public TeamEntity(String teamName, String country, List<DriverEntity> driverEntities, EngineManufacturerEntity engineManufacturerEntity) {
        this.id = UUID.randomUUID().toString();
        this.teamName = teamName;
        this.country = country;
        this.driverEntities = driverEntities;
        this.engineManufacturerEntity = engineManufacturerEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<DriverEntity> getDriverEntities() {
        return driverEntities;
    }

    public void setDriverEntities(List<DriverEntity> driverEntities) {
        this.driverEntities = driverEntities;
    }

    public EngineManufacturerEntity getEngineManufacturerEntity() {
        return engineManufacturerEntity;
    }

    public void setEngineManufacturerEntity(EngineManufacturerEntity engineManufacturerEntity) {
        this.engineManufacturerEntity = engineManufacturerEntity;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    @Override
    public String toString() {
        return "TeamEntity{" +
                "id='" + id + '\'' +
                ", teamName='" + teamName + '\'' +
                ", country='" + country + '\'' +
                ", driverEntities=" + driverEntities +
                ", engineManufacturerEntity=" + engineManufacturerEntity +
                ", mainColor='" + mainColor + '\'' +
                '}';
    }
}
