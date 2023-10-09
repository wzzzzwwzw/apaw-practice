package es.upm.miw.apaw_practice.adapters.mongodb.music.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SongEntity {
    private String title;

    private Integer duration;

    private Boolean remix;

    private Double rating;

    @DBRef
    private List<ArtistEntity> artistsEntitiesList;

    @DBRef
    private MusicGenreEntity musicGenreEntity;

    public SongEntity() {
        this.artistsEntitiesList = new ArrayList<>();
    }

    public SongEntity(String title, Integer duration, Boolean remix, Double rating, MusicGenreEntity musicGenreEntity, List<ArtistEntity> artistsEntitiesList) {
        this();
        this.title = title;
        this.duration = duration;
        this.remix = remix;
        this.rating = rating;
        this.musicGenreEntity = musicGenreEntity;
        this.artistsEntitiesList = artistsEntitiesList;
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

    public MusicGenreEntity getMusicGenreEntity() {
        return musicGenreEntity;
    }

    public void setMusicGenreEntity(MusicGenreEntity musicGenreEntity) {
        this.musicGenreEntity = musicGenreEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongEntity that = (SongEntity) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(duration, that.duration) && Objects.equals(remix, that.remix)
                && Objects.equals(rating, that.rating) && Objects.equals(artistsEntitiesList, that.artistsEntitiesList)
                && Objects.equals(musicGenreEntity, that.musicGenreEntity);
    }

    @Override
    public int hashCode() {
        return this.title.hashCode();
    } // asi es??

    @Override
    public String toString() {
        return "SongEntity{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", remix=" + remix +
                ", rating=" + rating +
                ", artistsEntitiesList=" + artistsEntitiesList +
                ", musicgenre=" + musicGenreEntity +
                '}';
    }
}
