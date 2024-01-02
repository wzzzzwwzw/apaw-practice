package es.upm.miw.apaw_practice.adapters.mongodb.olympics.entities;

import es.upm.miw.apaw_practice.domain.models.olympics.Athlete;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.UUID;

public class AthleteEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private Integer bib;
    private String familyName;
    private String gender;

    public AthleteEntity() {
        // empty from framework
    }

    public AthleteEntity(Athlete athlete) {
        BeanUtils.copyProperties(athlete, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBib() {
        return bib;
    }

    public void setBib(Integer bib) {
        this.bib = bib;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void fromAthlete(Athlete athlete) {
        BeanUtils.copyProperties(athlete, this);
    }

    public Athlete toAthlete() {
        Athlete athlete = new Athlete();
        BeanUtils.copyProperties(this, athlete);
        return athlete;
    }

    @Override
    public int hashCode() {
        return bib.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj ||
                obj != null && getClass() == obj.getClass() && (bib.equals(((AthleteEntity) obj).bib));
    }

    @Override
    public String toString() {
        return "AthleteEntity{" +
                "id='" + id + '\'' +
                ", bib=" + bib +
                ", familyName='" + familyName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
