package es.upm.miw.apaw_practice.domain.models.music;

import es.upm.miw.apaw_practice.domain.models.music.builders.SongBuilders;

import java.util.ArrayList;
import java.util.List;

public class Song {

    private String title;

    private Integer duration;

    private Boolean remix;

    private Double rating;

    private List<Artist> artistsList;

    private MusicGenre musicGenre;

    public Song() {
        this.artistsList = new ArrayList<>();
    }

    public Song(String title, Integer duration, Boolean remix, Double rating, MusicGenre musicGenre, List<Artist> artistsList) {
        this();
        this.title = title;
        this.duration = duration;
        this.remix = remix;
        this.rating = rating;
        this.musicGenre = musicGenre;
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

    public MusicGenre getMusicGenre() {
        return this.musicGenre;
    }

    public void setMusicGenre(MusicGenre musicGenre) {
        this.musicGenre = musicGenre;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + this.title + '\'' +
                ", duration=" + this.duration +
                ", isRemix=" + this.remix +
                ", rating=" + this.rating +
                ", artistsList=" + this.artistsList +
                ", Musicgenre=" + this.musicGenre +
                '}';
    }

    public static class Builder implements SongBuilders.Title, SongBuilders.Optionals {
        private final Song song;

        public Builder() {
            song = new Song();
        }

        @Override
        public SongBuilders.Optionals title(String title) {
            this.song.title = title;
            return this;
        }

        @Override
        public SongBuilders.Optionals duration(Integer duration) {
            this.song.duration = duration;
            return this;
        }

        @Override
        public SongBuilders.Optionals remix(Boolean remix) {
            this.song.remix = remix;
            return this;
        }

        @Override
        public SongBuilders.Optionals rating(Double rating) {
            this.song.rating = rating;
            return this;
        }

        @Override
        public SongBuilders.Optionals artistsList(List<Artist> artistsList) {
            this.song.artistsList = artistsList;
            return this;
        }

        @Override
        public SongBuilders.Optionals musicGenre(MusicGenre musicGenre) {
            this.song.musicGenre = musicGenre;
            return this;
        }

        @Override
        public Song build() {
            return this.song;
        }
    }
}
