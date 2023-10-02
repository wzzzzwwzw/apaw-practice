package es.upm.miw.apaw_practice.domain.models.music;

public class Genre {

    private String type;

    private String description;

    private Integer popularity;

    private String countryOrigin;

    public Genre() {
        //empty for framework
    }

    public Genre(String type, String description, Integer popularity, String countryOrigin) {
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
        return "Genre{" +
                "type='" + this.type + '\'' +
                ", description='" + this.description + '\'' +
                ", popularity=" + this.popularity +
                ", countryOrigin='" + this.countryOrigin + '\'' +
                '}';
    }
}
