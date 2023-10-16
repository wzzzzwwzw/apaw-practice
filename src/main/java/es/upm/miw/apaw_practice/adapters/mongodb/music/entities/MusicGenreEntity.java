package es.upm.miw.apaw_practice.adapters.mongodb.music.entities;

import es.upm.miw.apaw_practice.domain.models.music.MusicGenre;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class MusicGenreEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private String type;

    private String description;

    private Integer popularity;

    private String countryOrigin;

    public MusicGenreEntity() {
        //empty for framework
    }

    public MusicGenreEntity(String type, String description, Integer popularity, String countryOrigin) {
        this.type = type;
        this.description = description;
        this.popularity = popularity;
        this.countryOrigin = countryOrigin;
    }

    public MusicGenreEntity(MusicGenre musicGenre) {
        BeanUtils.copyProperties(musicGenre, this);
        this.id = UUID.randomUUID().toString();
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

    public MusicGenre toMusicGenre() {
        MusicGenre musicGenre = new MusicGenre();
        BeanUtils.copyProperties(this, musicGenre);
        return musicGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicGenreEntity that = (MusicGenreEntity) o;
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
        return "Musicgenre{" +
                "type='" + this.type + '\'' +
                ", description='" + this.description + '\'' +
                ", popularity=" + this.popularity +
                ", countryOrigin='" + this.countryOrigin + '\'' +
                '}';
    }
}
