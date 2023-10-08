package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities;

import es.upm.miw.apaw_practice.domain.models.formula_one.Driver;
import es.upm.miw.apaw_practice.domain.models.formula_one.Team;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class TeamEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String teamName;
    private String country;
    @DBRef
    private List<DriverEntity> driverEntities;
    private String mainColor;

    public TeamEntity() {
        //empty for framework
    }

    public TeamEntity(String teamName, String country, List<DriverEntity> driverEntities) {
        this.id = UUID.randomUUID().toString();
        this.teamName = teamName;
        this.country = country;
        this.driverEntities = driverEntities;
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

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public Team toTeam() {
        Team team = new Team();
        BeanUtils.copyProperties(this, team, "driverEntities");
        List<Driver> drivers = this.driverEntities.stream()
                .map(DriverEntity::toDriver)
                .collect(Collectors.toList());
        team.setDrivers(drivers);
        return team;
    }

    @Override
    public String toString() {
        return "TeamEntity{" +
                "id='" + id + '\'' +
                ", teamName='" + teamName + '\'' +
                ", country='" + country + '\'' +
                ", drivers=" + driverEntities +
                ", mainColor='" + mainColor + '\'' +
                '}';
    }
}
