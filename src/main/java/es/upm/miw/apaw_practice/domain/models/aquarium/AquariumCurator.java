package es.upm.miw.apaw_practice.domain.models.aquarium;

import java.util.ArrayList;
import java.util.List;

public class AquariumCurator {
    private String name;
    private String position;
    private boolean vacationState;
    private List<Fishpond> fishponds;
    private List<Aquarium> aquariums;


    public AquariumCurator(String name, String position, boolean vacationState, List<Fishpond> fishponds, List<Aquarium> aquariums) {
        this.name = name;
        this.position = position;
        this.vacationState = vacationState;
        this.fishponds = fishponds;
        this.aquariums = aquariums;

    }

    public AquariumCurator()
    {aquariums = new ArrayList<>();
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

    public boolean isVacationState() {
        return vacationState;
    }

    public void setVacationState(boolean vacationState) {
        this.vacationState = vacationState;
    }

    public List<Fishpond> getFishponds() {
        return fishponds;
    }

    public void setFishponds(List<Fishpond> fishponds) {
        this.fishponds = fishponds;
    }

    public List<Aquarium> getAquariums() {
        return aquariums;
    }

    public void setAquariums(List<Aquarium> aquariums) {
        this.aquariums = aquariums;
    }

    @Override
    public String toString() {
        return "AquariumCurator{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", vacationState=" + vacationState +
                ", fishponds=" + fishponds +
                ", aquariums=" + aquariums +
                '}';
    }
}