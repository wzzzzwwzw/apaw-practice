package es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities;

import es.upm.miw.apaw_practice.domain.models.climbing.Route;

import java.util.UUID;

public class RouteEntity {
    private String key;
    private String name;
    private String difficulty;

    public RouteEntity() {
        //empty for framework
    }

    public RouteEntity(String key, String name, String difficulty) {
        this.key = key;
        this.name = name;
        this.difficulty = difficulty;
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
        return new Route.Builder()
                .name(this.name)
                .difficulty(this.difficulty)
                .key(this.key)
                .build();
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
