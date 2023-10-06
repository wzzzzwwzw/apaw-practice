package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities;

import es.upm.miw.apaw_practice.domain.models.videogame_company.Videogame;
import es.upm.miw.apaw_practice.domain.models.videogame_company.VideogameCompany;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class VideogameCompanyEntity{
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String country;
    private LocalDate registrationDate;
    @DBRef
    private List<VideogameEntity> videogames;

    public VideogameCompanyEntity(){

    }

    public VideogameCompanyEntity(String name, String country, LocalDate registrationDate,
                                  List<VideogameEntity> videogames) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.country = country;
        this.registrationDate = registrationDate;
        this.videogames = videogames;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<VideogameEntity> getVideogames() {
        return videogames;
    }

    public void setVideogames(List<VideogameEntity> videogames) {
        this.videogames = videogames;
    }

    public VideogameCompany toVideogameCompany(){
        List<Videogame> videogameList = this.videogames.stream()
                .map(VideogameEntity::toVideogame)
                .collect(Collectors.toList());
        VideogameCompany videogameCompany = new VideogameCompany(this.name, this.country, this.registrationDate);
        videogameCompany.setVideogames(videogameList);
        return videogameCompany;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass()
                && (name.equals(((VideogameCompanyEntity) obj).name));
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return "VideogameCompanyEntity{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", registrationDate=" + registrationDate +
                ", videogames=" + videogames +
                '}';
    }
}
