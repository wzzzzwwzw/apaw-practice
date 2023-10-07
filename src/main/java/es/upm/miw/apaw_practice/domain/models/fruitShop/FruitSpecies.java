package es.upm.miw.apaw_practice.domain.models.fruitShop;

public class FruitSpecies {

    private String species;

    private String season;

    private Integer size;


    public FruitSpecies() {
        //empty for framework
    }


    public FruitSpecies(String species, String season, Integer size) {
        this.species = species;
        this.season = season;
        this.size = size;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "FruitSpecies{" +
                "species='" + species + '\'' +
                ", season='" + season + '\'' +
                ", size=" + size +
                '}';
    }
}
