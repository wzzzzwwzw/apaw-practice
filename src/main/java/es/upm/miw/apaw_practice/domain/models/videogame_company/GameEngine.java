package es.upm.miw.apaw_practice.domain.models.videogame_company;

import es.upm.miw.apaw_practice.domain.models.videogame_company.builders.FeatureBuilders;
import es.upm.miw.apaw_practice.domain.models.videogame_company.builders.GameEngineBuilders;

public class GameEngine {
    private String name;
    private String programmingLanguage;
    private String license;

    public GameEngine(){

    }
    public GameEngine(String name, String programmingLanguage, String license) {
        this.name = name;
        this.programmingLanguage = programmingLanguage;
        this.license = license;
    }

    public static GameEngineBuilders.Name build(){
        return new Builder();
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

    @Override
    public String toString() {
        return "GameEngine{" +
                "name='" + name + '\'' +
                ", ProgrammingLanguage='" + programmingLanguage + '\'' +
                ", License='" + license + '\'' +
                '}';
    }

    public static class Builder implements GameEngineBuilders.Name, GameEngineBuilders.ProgrammingLanguage,
            GameEngineBuilders.License, GameEngineBuilders.Build{

        private final GameEngine gameEngine;
        public Builder(){ this.gameEngine = new GameEngine();}
        @Override
        public GameEngineBuilders.ProgrammingLanguage name(String name){
            this.gameEngine.name = name;
            return this;
        }
        @Override
        public GameEngineBuilders.License programmingLanguage(String programmingLanguage){
            this.gameEngine.programmingLanguage = programmingLanguage;
            return this;
        }
        @Override
        public GameEngineBuilders.Build license(String license){
            this.gameEngine.license = license;
            return this;
        }
        @Override
        public GameEngine build(){ return this.gameEngine; }
    }

}
