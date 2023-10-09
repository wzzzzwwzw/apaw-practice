package es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities;

import es.upm.miw.apaw_practice.domain.models.climbing.Route;

import java.util.UUID;

public class RouteEntity {
    private String key;
    private String name;
    private String difficulty;

    public RouteEntity() {

    }

    public RouteEntity(String name, String difficulty) {
        this.key = UUID.randomUUID().toString();
        this.name = name;
        this.difficulty = difficulty;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Route toRoute() {
        return new Route(this.key, this.name, this.difficulty);
    }

    @Override
    public String toString() {
        return "RouteEntity{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
