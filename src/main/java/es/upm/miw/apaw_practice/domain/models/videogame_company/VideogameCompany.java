package es.upm.miw.apaw_practice.domain.models.videogame_company;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class VideogameCompany {

    private String name;
    private String country;
    private LocalDate registrationDate;
    private List<Videogame> videogames;

    public VideogameCompany(){
        this.videogames = new ArrayList<>();
    }

    public VideogameCompany(String name, String country, LocalDate registrationDate){
        this();
        this.name = name;
        this.country = country;
        this.registrationDate = registrationDate;
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

    public List<Videogame> getVideogames() {
        return videogames;
    }

    public void setVideogames(List<Videogame> videogames) {
        this.videogames = videogames;
    }

    public void addVideogame(Videogame videogame){
        this.videogames.add(videogame);
    }

    @Override
    public String toString() {
        return "VideogameCompany{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", registrationDate=" + registrationDate +
                ", videogames=" + videogames +
                '}';
    }
}



