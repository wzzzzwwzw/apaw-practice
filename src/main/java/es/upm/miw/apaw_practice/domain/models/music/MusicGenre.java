package es.upm.miw.apaw_practice.domain.models.music;

import es.upm.miw.apaw_practice.domain.models.music.builders.MusicGenreBuilders;

public class MusicGenre {

    private String type;

    private String description;

    private Integer popularity;

    private String countryOrigin;

    public MusicGenre() {
        //empty for framework
    }

    public MusicGenre(String type, String description, Integer popularity, String countryOrigin) {
        this.type = type;
        this.description = description;
        this.popularity = popularity;
        this.countryOrigin = countryOrigin;
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
    public String toString() {
        return "Musicgenre{" +
                "type='" + this.type + '\'' +
                ", description='" + this.description + '\'' +
                ", popularity=" + this.popularity +
                ", countryOrigin='" + this.countryOrigin + '\'' +
                '}';
    }

    public static class Builder implements MusicGenreBuilders.Type, MusicGenreBuilders.Optionals {
        private final MusicGenre musicGenre;

        public Builder() {
            musicGenre = new MusicGenre();
        }

        @Override
        public MusicGenreBuilders.Optionals type(String type) {
            this.musicGenre.type = type;
            return this;
        }

        @Override
        public MusicGenreBuilders.Optionals description(String description) {
            this.musicGenre.description = description;
            return this;
        }

        @Override
        public MusicGenreBuilders.Optionals popularity(Integer popularity) {
            this.musicGenre.popularity = popularity;
            return this;
        }

        @Override
        public MusicGenreBuilders.Optionals countryOrigin(String countryOrigin) {
            this.musicGenre.countryOrigin = countryOrigin;
            return this;
        }

        @Override
        public MusicGenre build() {
            return this.musicGenre;
        }
    }
}
