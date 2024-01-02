package es.upm.miw.apaw_practice.adapters.mongodb.airport.entities;

import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class AirLineEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private LocalDate dayOfFoundation;
    private List<AircraftEntity> aircrafts;

    public AirLineEntity(){
        //empty for framework
    }

    public AirLineEntity(String name, LocalDate dayOfFoundation, List<AircraftEntity> aircrafts) {
        this.name = name;
        this.dayOfFoundation = dayOfFoundation;
        this.aircrafts = aircrafts;
        this.id = UUID.randomUUID().toString();
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

    public LocalDate getDayOfFoundation() {
        return dayOfFoundation;
    }

    public void setDayOfFoundation(LocalDate dayOfFoundation) {
        this.dayOfFoundation = dayOfFoundation;
    }

    public List<AircraftEntity> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(List<AircraftEntity> aircrafts) {
        this.aircrafts = aircrafts;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((AirLineEntity) obj).name));
    }

    public AirLine toAirLine(){
        List<Aircraft> aircraftsTransformed = aircrafts.stream()
                .map(air -> {
                    Aircraft aircraft = air.toAircraft();
                    return aircraft;
                })
                .collect(Collectors.toList());
        return new AirLine(name, dayOfFoundation, aircraftsTransformed);
    }

    @Override
    public String toString() {
        return "AirLineEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dayOfFoundation=" + dayOfFoundation +
                ", aircrafts=" + aircrafts +
                '}';
    }
}
