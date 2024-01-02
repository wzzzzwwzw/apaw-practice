package es.upm.miw.apaw_practice.adapters.mongodb.olympics.entities;

import es.upm.miw.apaw_practice.domain.models.olympics.Athlete;
import es.upm.miw.apaw_practice.domain.models.olympics.NOC;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class NOCEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String code;
    private String committeeName;
    private Integer yearOfFoundation;
    private List<AthleteEntity> athleteEntities;

    public NOCEntity(String id, String code, String committeeName, List<AthleteEntity> athleteEntities) {
        this.id = id;
        this.code = code;
        this.committeeName = committeeName;
        this.athleteEntities = athleteEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCommitteeName() {
        return committeeName;
    }

    public void setCommitteeName(String committeeName) {
        this.committeeName = committeeName;
    }

    public Integer getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(Integer yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public List<AthleteEntity> getAthleteEntities() {
        return athleteEntities;
    }

    public void setAthleteEntities(List<AthleteEntity> athleteEntities) {
        this.athleteEntities = athleteEntities;
    }

    public NOC toNOC() {
        List<Athlete> athletes = this.athleteEntities.stream()
                .map(AthleteEntity::toAthlete)
                .toList();
        return new NOC(code, committeeName, yearOfFoundation, athletes);
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (code.equals(((NOCEntity) obj).code));
    }

    @Override
    public String toString() {
        return "NOCEntity{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", committeeName='" + committeeName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", athleteEntities=" + athleteEntities +
                '}';
    }
}
