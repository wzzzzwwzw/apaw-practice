package es.upm.miw.apaw_practice.domain.models.zoo;

import java.util.List;

public class Animal {


    private String identificationChip;
    private String name;
    private Integer age;
    private TaxonomicSpecie taxonomicSpecie;
    private List<Vaccine> vaccines;

    public Animal() {
        //empty for framework
    }

    public Animal(String identificationChip, String name, Integer age, TaxonomicSpecie taxonomicSpecie, List<Vaccine> vaccines) {
        this.identificationChip = identificationChip;
        this.name = name;
        this.age = age;
        this.taxonomicSpecie = taxonomicSpecie;
        this.vaccines = vaccines;
    }

    public String getIdentificationChip() {
        return identificationChip;
    }

    public void setIdentificationChip(String identificationChip) {
        this.identificationChip = identificationChip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public TaxonomicSpecie getTaxonomicSpecie() {
        return taxonomicSpecie;
    }

    public void setTaxonomicSpecie(TaxonomicSpecie taxonomicSpecie) {
        this.taxonomicSpecie = taxonomicSpecie;
    }

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "identificationChip='" + identificationChip + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", taxonomicSpecie=" + taxonomicSpecie +
                ", vaccines=" + vaccines +
                '}';
    }
}
