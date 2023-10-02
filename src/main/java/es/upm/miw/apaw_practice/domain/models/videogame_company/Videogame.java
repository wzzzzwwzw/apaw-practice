package es.upm.miw.apaw_practice.domain.models.videogame_company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Videogame {
    private String name;
    private String length;
    private BigInteger price;
    private String ratingCategory;
    private Date releaseDate;
    private GameEngine gameEngine;
    private List<Feature> features;

    private Videogame(){
        this.features = new ArrayList<>();
    }

    public Videogame(String name, String length, BigInteger price,
                     String ratingCategory, Date releaseDate, GameEngine gameEngine) {
        this();
        this.name = name;
        this.length = length;
        this.price = price;
        this.ratingCategory = ratingCategory;
        this.releaseDate = releaseDate;
        this.gameEngine = gameEngine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public String getRatingCategory() {
        return ratingCategory;
    }

    public void setRatingCategory(String ratingCategory) {
        this.ratingCategory = ratingCategory;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
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
                ", length='" + length + '\'' +
                ", price=" + price +
                ", ratingCategory='" + ratingCategory + '\'' +
                ", releaseDate=" + releaseDate +
                ", gameEngine=" + gameEngine +
                ", features=" + features +
                '}';
    }

}
