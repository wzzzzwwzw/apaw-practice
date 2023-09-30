package es.upm.miw.apaw_practice.domain.models.zoo;


import java.math.BigDecimal;
import java.util.List;

public class Zoo {
    private String name;
    private String location;
    private BigDecimal ticketPrice;
    private List<Animal> animals;

    public Zoo() {
        //empty for framework
    }


    public Zoo(String name, String location, BigDecimal ticketPrice, List<Animal> animals) {
        this.name = name;
        this.location = location;
        this.ticketPrice = ticketPrice;
        this.animals = animals;
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

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", animals=" + animals +
                '}';
    }
}
