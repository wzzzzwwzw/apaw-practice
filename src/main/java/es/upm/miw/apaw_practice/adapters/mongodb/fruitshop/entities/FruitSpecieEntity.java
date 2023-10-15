package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities;

import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.FruitSpecieEntity;
import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitSpecie;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class FruitSpecieEntity {
    @Id
    private String id;

    @Indexed(unique = true)

    private String specie;

    private String season;

    private Integer size;

    public FruitSpecieEntity() {
        //empty for framework
    }

    public FruitSpecieEntity(FruitSpecie fruitSpecie) {
        BeanUtils.copyProperties(fruitSpecie, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public FruitSpecie toFruitSpecie() {
        FruitSpecie fruitSpecie = new FruitSpecie();
        BeanUtils.copyProperties(this, fruitSpecie);
        return fruitSpecie;
    }

    @Override
    public boolean equals(Object obj) {
        FruitSpecieEntity objAux = (FruitSpecieEntity) obj;
        return this == obj || obj != null && getClass() == obj.getClass() && (this.specie.equals(objAux.getSpecie()));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "FruitSpecieEntity{" +
                "id='" + id + '\'' +
                ", specie='" + specie + '\'' +
                ", season='" + season + '\'' +
                ", size=" + size +
                '}';
    }
}
