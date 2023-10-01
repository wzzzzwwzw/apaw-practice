package es.upm.miw.apaw_practice.domain.models.music;

import java.util.ArrayList;
import java.util.List;

public class Song {

    private String title;

    private Integer duration;

    private Boolean isRemix;

    private Double rating;

    private List<Artist> artistsList;

    private Genre genre;

    public Song() {
        this.artistsList = new ArrayList<>();
    }

    public Song(String title, Integer duration, Boolean isRemix, Double rating, Genre genre) {
        this();
        this.title = title;
        this.duration = duration;
        this.isRemix = isRemix;
        this.rating = rating;
        this.genre = genre;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getIsRemix() {
        return this.isRemix;
    }

    public void setIsRemix(Boolean isRemix) {
        this.isRemix = isRemix;
    }

    public Double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<Artist> getArtistsList() {
        return this.artistsList;
    }

    public void setArtistsList(List<Artist> artistsList) {
        this.artistsList = artistsList;
    }

    public void addArtist(Artist artist) {
        this.artistsList.add(artist);
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + this.title + '\'' +
                ", duration=" + this.duration +
                ", isRemix=" + this.isRemix +
                ", rating=" + this.rating +
                ", artistsList=" + this.artistsList +
                ", genre=" + this.genre +
                '}';
    }
}
