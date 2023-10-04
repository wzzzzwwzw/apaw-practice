package es.upm.miw.apaw_practice.domain.models.videogame_company;

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

}
