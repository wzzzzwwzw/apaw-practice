package es.upm.miw.apaw_practice.adapters.mongodb.olympics.entities;

import es.upm.miw.apaw_practice.domain.models.olympics.Sport;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class SportEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String sportName;
    private String governingBody;

    public SportEntity() {
        // empty from framework
    }

    public SportEntity(Sport sport) {
        BeanUtils.copyProperties(sport, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getGoverningBody() {
        return governingBody;
    }

    public void setGoverningBody(String governingBody) {
        this.governingBody = governingBody;
    }

    public void fromSport(Sport sport) {
        BeanUtils.copyProperties(sport, this);
    }

    public Sport toSport() {
        Sport sport = new Sport();
        BeanUtils.copyProperties(this, sport);
        return sport;
    }

    @Override
    public int hashCode() {
        return sportName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj ||
                obj != null && getClass() == obj.getClass() && (sportName.equals(((SportEntity) obj).sportName));
    }

    @Override
    public String toString() {
        return "SportEntity{" +
                "id='" + id + '\'' +
                ", sportName='" + sportName + '\'' +
                ", governingBody='" + governingBody + '\'' +
                '}';
    }
}
