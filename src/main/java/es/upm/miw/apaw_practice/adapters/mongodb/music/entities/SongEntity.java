package es.upm.miw.apaw_practice.adapters.mongodb.music.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class SongEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private String title;

    private Integer duration;

    private Boolean remix;

    private Double rating;

    @DBRef
    private List<ArtistEntity> artistsEntitiesList;

    @DBRef
    private GenreEntity genre;

    public SongEntity() {
        this.artistsEntitiesList = new ArrayList<>();
    }

    public SongEntity(String title, Integer duration, Boolean remix, Double rating, GenreEntity genre, List<ArtistEntity> artistsEntitiesList) {
        this();
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.duration = duration;
        this.remix = remix;
        this.rating = rating;
        this.genre = genre;
        this.artistsEntitiesList = artistsEntitiesList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean isRemix() {
        return remix;
    }

    public void setRemix(Boolean remix) {
        this.remix = remix;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<ArtistEntity> getArtistsList() {
        return artistsEntitiesList;
    }

    public void setArtistsList(List<ArtistEntity> artistsEntitiesList) {
        this.artistsEntitiesList = artistsEntitiesList;
    }

    public void addArtist(ArtistEntity artist) {
        this.artistsEntitiesList.add(artist);
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongEntity that = (SongEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) &&
                Objects.equals(duration, that.duration) && Objects.equals(remix, that.remix)
                && Objects.equals(rating, that.rating) && Objects.equals(artistsEntitiesList, that.artistsEntitiesList)
                && Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "SongEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", remix=" + remix +
                ", rating=" + rating +
                ", artistsList=" + artistsEntitiesList +
                ", genre=" + genre +
                '}';
    }
}
