package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities;

import es.upm.miw.apaw_practice.domain.models.videogame_company.Feature;
import es.upm.miw.apaw_practice.domain.models.videogame_company.GameEngine;
import es.upm.miw.apaw_practice.domain.models.videogame_company.Videogame;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document
public class VideogameEntity{
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private BigDecimal price;
    private LocalDate releaseDate;
    @DBRef
    private GameEngineEntity gameEngine;
    @DBRef
    private List<FeatureEntity> features;

    private VideogameEntity(){

    }

    public VideogameEntity(String name, BigDecimal price, LocalDate releaseDate,
                           GameEngineEntity gameEngine, List<FeatureEntity> features) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
        this.gameEngine = gameEngine;
        this.features = features;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public GameEngineEntity getGameEngine() {
        return gameEngine;
    }

    public void setGameEngine(GameEngineEntity gameEngine) {
        this.gameEngine = gameEngine;
    }

    public List<FeatureEntity> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureEntity> features) {
        this.features = features;
    }

    public Videogame toVideogame(){
        GameEngine newGameEngine = this.gameEngine.toGameEngine();
        List<Feature> featureList = this.features.stream()
                .map(FeatureEntity::toFeature)
                .toList();
        Videogame videogame = new Videogame(this.name, this.price, this.releaseDate, newGameEngine);
        videogame.setFeatures(featureList);
        return videogame;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass()
                && (name.equals(((VideogameEntity) obj).name));
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return "VideogameEntity{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", gameEngine=" + gameEngine +
                ", features=" + features +
                '}';
    }
}
