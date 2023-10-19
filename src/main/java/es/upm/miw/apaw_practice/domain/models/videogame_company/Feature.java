package es.upm.miw.apaw_practice.domain.models.videogame_company;

import es.upm.miw.apaw_practice.domain.models.videogame_company.builders.FeatureBuilders;

public class Feature{
    private String genre;
    private String gameStyle;
    private Boolean cloudSynchronization;

    public Feature() {
    }

    public Feature(String genre, String gameStyle, Boolean cloudSynchronization) {
        this.genre = genre;
        this.gameStyle = gameStyle;
        this.cloudSynchronization = cloudSynchronization;
    }

    public static FeatureBuilders.Genre build(){
        return new Builder();
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGameStyle() {
        return gameStyle;
    }

    public void setGameStyle(String gameStyle) {
        this.gameStyle = gameStyle;
    }

    public Boolean getCloudSynchronization() {
        return cloudSynchronization;
    }

    public void setCloudSynchronization(Boolean cloudSynchronization) {
        this.cloudSynchronization = cloudSynchronization;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "genre='" + genre + '\'' +
                ", gameStyle='" + gameStyle + '\'' +
                ", cloudSynchronization=" + cloudSynchronization +
                '}';
    }

    public static class Builder implements FeatureBuilders.Genre, FeatureBuilders.GameStyle,
            FeatureBuilders.CloudSynchronization, FeatureBuilders.Build{
        private final Feature feature;

        public Builder(){this.feature = new Feature();}

        @Override
        public FeatureBuilders.GameStyle genre(String genre){
            this.feature.genre = genre;
            return this;
        }

        @Override
        public FeatureBuilders.CloudSynchronization gameStyle(String gameStyle){
            this.feature.gameStyle = gameStyle;
            return this;
        }

        @Override
        public FeatureBuilders.Build cloudSynchronization(Boolean cloudSynchronization){
            this.feature.cloudSynchronization = cloudSynchronization;
            return this;
        }

        @Override
        public Feature build(){
            return this.feature;
        }
    }

}
