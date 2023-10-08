package es.upm.miw.apaw_practice.adapters.mongodb.film.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document
public class FilmEntity {

    @Id
    private String id;
    private String title;
    private String synopsis;
    private LocalDate releaseDate;
    @DBRef
    private List<GenreEntity> genreEntities;
    @DBRef
    private DirectorEntity directorEntity;
    private List<ReviewEntity> reviewEntities;

    public FilmEntity(String title, String synopsis, List<GenreEntity> genreEntities,
                      DirectorEntity directorEntity, List<ReviewEntity> reviewEntities) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.synopsis = synopsis;
        this.releaseDate = LocalDate.now();
        this.genreEntities = genreEntities;
        this.directorEntity = directorEntity;
        this.reviewEntities = reviewEntities;
    }

    public String getId() {
        return id;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<GenreEntity> getGenreEntities() {
        return genreEntities;
    }

    public void setGenreEntities(List<GenreEntity> genreEntities) {
        this.genreEntities = genreEntities;
    }

    public DirectorEntity getDirectorEntity() {
        return directorEntity;
    }

    public void setDirectorEntity(DirectorEntity directorEntity) {
        this.directorEntity = directorEntity;
    }

    public List<ReviewEntity> getReviewEntities() {
        return reviewEntities;
    }

    public void setReviewEntities(List<ReviewEntity> reviewEntities) {
        this.reviewEntities = reviewEntities;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((FilmEntity) obj).id));
    }

    @Override
    public String toString() {
        return "FilmEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", releaseDate=" + releaseDate +
                ", genreEntities=" + genreEntities +
                ", directorEntity=" + directorEntity +
                ", reviewEntities=" + reviewEntities +
                '}';
    }
}
