package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities;

import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class CompetitorEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String nationality;
    private Integer age;

    public CompetitorEntity() {
    }

    public CompetitorEntity(Competitor competitor) {
        BeanUtils.copyProperties(competitor, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Competitor toCompetitor() {
        Competitor competitor = new Competitor();
        BeanUtils.copyProperties(this, competitor);
        return competitor;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (name.equals(((CompetitorEntity) obj).name));

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "CompetitorEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                '}';
    }
}
