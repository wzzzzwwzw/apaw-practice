package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities;

import es.upm.miw.apaw_practice.domain.models.videogame_company.GameEngine;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class GameEngineEntity{
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String programmingLanguage;
    private String license;

    private GameEngineEntity(){

    }
    public GameEngineEntity(String name, String programmingLanguage, String license) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.programmingLanguage = programmingLanguage;
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
    public GameEngine toGameEngine(){
        GameEngine gameEngine = new GameEngine();
        BeanUtils.copyProperties(this, gameEngine);
        return gameEngine;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass()
                && (name.equals(((GameEngineEntity) obj).name));
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return "GameEngineEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", programmingLanguage='" + programmingLanguage + '\'' +
                ", license='" + license + '\'' +
                '}';
    }
}
