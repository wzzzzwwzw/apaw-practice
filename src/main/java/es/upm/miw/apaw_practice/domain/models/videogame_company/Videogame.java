package es.upm.miw.apaw_practice.domain.models.videogame_company;

import es.upm.miw.apaw_practice.domain.models.videogame_company.builders.VideogameBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Videogame {
    private String name;
    private BigDecimal price;
    private LocalDate releaseDate;
    private GameEngine gameEngine;
    private List<Feature> features;

    private Videogame(){
        this.features = new ArrayList<>();
    }

    public Videogame(String name, BigDecimal price, LocalDate releaseDate, GameEngine gameEngine) {
        this();
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
        this.gameEngine = gameEngine;
    }

    public static VideogameBuilders.Name build(){
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }

    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public void addFeature(Feature feature){
        this.features.add(feature);
    }

    @Override
    public String toString() {
        return "Videogame{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", gameEngine=" + gameEngine +
                ", features=" + features +
                '}';
    }

    public static class Builder implements VideogameBuilders.Name, VideogameBuilders.Price,
            VideogameBuilders.ReleaseDate, VideogameBuilders.Engine, VideogameBuilders.Features,
            VideogameBuilders.Build{
        private final Videogame videogame;

        public Builder(){ this.videogame = new Videogame();}

        @Override
        public VideogameBuilders.Price name(String name){
            this.videogame.name = name;
            return this;
        }

        @Override
        public VideogameBuilders.ReleaseDate price(BigDecimal price){
            this.videogame.price = price;
            return this;
        }

        @Override
        public VideogameBuilders.Engine releaseDate(LocalDate releaseDate){
            this.videogame.releaseDate = releaseDate;
            return this;
        }

        @Override
        public VideogameBuilders.Features engine(GameEngine gameEngine){
            this.videogame.gameEngine = gameEngine;
            return this;
        }

        @Override
        public VideogameBuilders.Build features(List<Feature> features){
            this.videogame.features = features;
            return this;
        }

        @Override
        public Videogame build(){return this.videogame;}

    }

}
