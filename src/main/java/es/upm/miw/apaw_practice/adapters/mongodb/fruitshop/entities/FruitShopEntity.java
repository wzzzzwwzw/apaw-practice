package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities;
import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitShop;
import es.upm.miw.apaw_practice.domain.models.fruitShop.Fruit;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Document
public class FruitShopEntity {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
    private String address;

    @DBRef
    private List<FruitEntity> fruitEntities;

    public FruitShopEntity() {
        //empty for framework
    }

    public FruitShopEntity(String id, String name, String address, List<FruitEntity> fruitEntities) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.fruitEntities = fruitEntities;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<FruitEntity> getFruitEntities() {
        return fruitEntities;
    }

    public void setFruitEntities(List<FruitEntity> fruitEntities) {
        this.fruitEntities = fruitEntities;
    }

    public FruitShop toFruitShop() {
        List<Fruit> fruits = this.fruitEntities.stream()
                .map(FruitEntity::toFruit)
                .collect(Collectors.toList());
        return new FruitShop(this.name, this.address,fruits);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean equals(Object obj) {
        FruitShopEntity objAux = (FruitShopEntity) obj;
        return this == obj || obj != null && getClass() == obj.getClass() && (this.name.equals(objAux.getName()));
    }


    @Override
    public String toString() {
        return "FruitShopEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", fruitEntities=" + fruitEntities +
                '}';
    }
}
