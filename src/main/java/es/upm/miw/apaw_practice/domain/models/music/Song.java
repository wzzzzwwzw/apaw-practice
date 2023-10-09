package es.upm.miw.apaw_practice.domain.models.music;

import java.util.ArrayList;
import java.util.List;

public class Song {

    private String title;

    private Integer duration;

    private Boolean remix;

    private Double rating;

    private List<Artist> artistsList;

    private Genre genre;

    public Song() {
        this.artistsList = new ArrayList<>();
    }

    public Song(String title, Integer duration, Boolean remix, Double rating, Genre genre, List<Artist> artistsList) {
        this();
        this.title = title;
        this.duration = duration;
        this.remix = remix;
        this.rating = rating;
        this.genre = genre;
        this.artistsList = artistsList;
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

    public Boolean isRemix() {
        return this.remix;
    }

    public void setRemix(Boolean remix) {
        this.remix = remix;
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
                ", isRemix=" + this.remix +
                ", rating=" + this.rating +
                ", artistsList=" + this.artistsList +
                ", genre=" + this.genre +
                '}';
    }
}
