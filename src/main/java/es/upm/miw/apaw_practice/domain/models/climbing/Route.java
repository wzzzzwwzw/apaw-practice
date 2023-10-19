package es.upm.miw.apaw_practice.domain.models.climbing;

import es.upm.miw.apaw_practice.domain.models.climbing.builders.RouteBuilders;

public class Route {
    private String key;
    private String name;
    private String difficulty;

    public Route() {

    }

    public static RouteBuilders.Name builder() {
        return new Builder();
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

    @Override
    public String toString() {
        return "Route{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }

    public static class Builder implements RouteBuilders.Name, RouteBuilders.Difficulty, RouteBuilders.Optionals {
        private final Route route;

        public Builder() {
            this.route = new Route();
        }

        @Override
        public RouteBuilders.Optionals difficulty(String difficulty) {
            this.route.setDifficulty(difficulty);
            return this;
        }

        @Override
        public RouteBuilders.Optionals key(String key) {
            this.route.setKey(key);
            return this;
        }

        @Override
        public Route build() {
            return this.route;
        }

        @Override
        public RouteBuilders.Difficulty name(String name) {
            this.route.setName(name);
            return this;
        }
    }
}
