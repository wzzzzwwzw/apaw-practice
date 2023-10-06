package es.upm.miw.apaw_practice.domain.models.furniture_store;

public class Material {
    private String name;
    private String type;
    private Integer durability;

    public Material() {
        //empty from framework
    }

    public Material(String name, String type, Integer durability) {
        this.name = name;
        this.type = type;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDurability() {
        return durability;
    }

    public void setDurability(Integer durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", durability=" + durability +
                '}';
    }

}
