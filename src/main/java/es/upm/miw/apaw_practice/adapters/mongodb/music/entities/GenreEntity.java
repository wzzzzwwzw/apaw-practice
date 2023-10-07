package es.upm.miw.apaw_practice.adapters.mongodb.music.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class GenreEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private String type;

    private String description;

    private Integer popularity;

    private String countryOrigin;

    public GenreEntity() {
        //empty for framework
    }

    public GenreEntity(String type, String description, Integer popularity, String countryOrigin) {
        this.type = type;
        this.description = description;
        this.popularity = popularity;
        this.countryOrigin = countryOrigin;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPopularity() {
        return this.popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public String getCountryOrigin() {
        return this.countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreEntity that = (GenreEntity) o;
        return Objects.equals(this.type, that.type) && Objects.equals(this.description, that.description) &&
                Objects.equals(this.popularity, that.popularity) &&
                Objects.equals(this.countryOrigin, that.countryOrigin);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "Genre{" +
                "type='" + this.type + '\'' +
                ", description='" + this.description + '\'' +
                ", popularity=" + this.popularity +
                ", countryOrigin='" + this.countryOrigin + '\'' +
                '}';
    }
}
