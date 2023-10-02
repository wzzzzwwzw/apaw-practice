package es.upm.miw.apaw_practice.domain.models.videogame_company;

public class Feature {
        private String genre;
        private String gameStyle;
        private Integer numberOfPlayers;
        private Boolean isCloudSave;

    public Feature(String genre, String gameStyle, Integer numberOfPlayers, Boolean isCloudSave) {
        this.genre = genre;
        this.gameStyle = gameStyle;
        this.numberOfPlayers = numberOfPlayers;
        this.isCloudSave = isCloudSave;
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

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Boolean getCloudSave() {
        return isCloudSave;
    }

    public void setCloudSave(Boolean cloudSave) {
        isCloudSave = cloudSave;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "genre='" + genre + '\'' +
                ", gameStyle='" + gameStyle + '\'' +
                ", numberOfPlayers=" + numberOfPlayers +
                ", isCloudSave=" + isCloudSave +
                '}';
    }
}
