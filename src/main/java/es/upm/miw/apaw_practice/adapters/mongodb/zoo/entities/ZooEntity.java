package es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities;

import es.upm.miw.apaw_practice.domain.models.zoo.Animal;
import es.upm.miw.apaw_practice.domain.models.zoo.Zoo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Document
public class ZooEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String location;
    private BigDecimal ticketPrice;
    @DBRef
    private List<AnimalEntity> animalEntities;

    public ZooEntity() {
        //empty for framework
    }


    public ZooEntity(String name, String location, BigDecimal ticketPrice, List<AnimalEntity> animalEntities) {
        this.name = name;
        this.location = location;
        this.ticketPrice = ticketPrice;
        this.animalEntities = animalEntities;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public List<AnimalEntity> getAnimalEntities() {
        return animalEntities;
    }

    public void setAnimalEntities(List<AnimalEntity> animalEntities) {
        this.animalEntities = animalEntities;
    }

    public Zoo toZoo() {
        List<Animal> animals = this.animalEntities.stream()
                .map(AnimalEntity::toAnimal)
                .collect(Collectors.toList());
        return new Zoo(this.name, this.location, this.ticketPrice, animals);
    }

    public boolean equals(Object obj) {
        ZooEntity objAux = (ZooEntity) obj;
        return this == obj || obj != null && getClass() == obj.getClass() && (this.name.equals(objAux.getName()));
    }

    @Override
    public String toString() {
        return "ZooEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", animalEntities=" + animalEntities +
                '}';
    }
}
