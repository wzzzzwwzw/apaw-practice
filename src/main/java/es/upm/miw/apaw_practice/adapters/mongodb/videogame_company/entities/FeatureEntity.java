package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities;

import es.upm.miw.apaw_practice.domain.models.videogame_company.Feature;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class FeatureEntity{
    @Id
    private String id;
    private String genre;
    private String gameStyle;
    private Boolean cloudSynchronization;

    private FeatureEntity(){

    }
    public FeatureEntity(String genre, String gameStyle, Boolean cloudSynchronization) {
        this.id = UUID.randomUUID().toString();
        this.genre = genre;
        this.gameStyle = gameStyle;
        this.cloudSynchronization = cloudSynchronization;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Feature toFeature(){
        Feature feature = new Feature();
        BeanUtils.copyProperties(this, feature);
        return feature;
    }

    @Override
    public String toString() {
        return "FeatureEntity{" +
                "id='" + id + '\'' +
                ", genre='" + genre + '\'' +
                ", gameStyle='" + gameStyle + '\'' +
                ", cloudSynchronization=" + cloudSynchronization +
                '}';
    }
}
