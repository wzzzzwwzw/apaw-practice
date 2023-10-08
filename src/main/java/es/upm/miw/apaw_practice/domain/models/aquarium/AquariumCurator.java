package es.upm.miw.apaw_practice.domain.models.aquarium;

import java.util.ArrayList;
import java.util.List;

public class AquariumCurator {
    private String name;
    private String position;
    private Boolean vacationState;
    private List<Fishpond> fishponds;
    private  Aquarium aquarium;


    public AquariumCurator(String name, String position, Boolean vacationState, List<Fishpond> fishponds, Aquarium aquarium) {
        this.name = name;
        this.position = position;
        this.vacationState = vacationState;
        this.fishponds = fishponds;
        this.aquarium = aquarium;
    }

    public AquariumCurator()
    {aquarium = new Aquarium();
        fishponds = new ArrayList<>();}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean isVacationState() {
        return vacationState;
    }

    public void setVacationState(Boolean vacationState) {
        this.vacationState = vacationState;
    }

    public List<Fishpond> getFishponds() {
        return fishponds;
    }

    public void setFishponds(List<Fishpond> fishponds) {
        this.fishponds = fishponds;
    }

    public Aquarium getAquarium() {
        return aquarium;
    }

    public void setAquarium(Aquarium aquarium) {
        this.aquarium = aquarium;
    }

    @Override
    public String toString() {
        return "AquariumCurator{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", vacationState=" + vacationState +
                ", fishponds=" + fishponds +
                ", aquariums=" + aquarium +
                '}';
    }
}