package es.upm.miw.apaw_practice.domain.models.fruitShop;

public class FruitSpecie {

    private String specie;

    private String season;

    private Integer size;


    public FruitSpecie() {
        //empty for framework
    }


    public FruitSpecie(String specie, String season, Integer size) {
        this.specie = specie;
        this.season = season;
        this.size = size;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
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
        return "FruitSpecie{" +
                "specie='" + specie + '\'' +
                ", season='" + season + '\'' +
                ", size=" + size +
                '}';
    }
}
