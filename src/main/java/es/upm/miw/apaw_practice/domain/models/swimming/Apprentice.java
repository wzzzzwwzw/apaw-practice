package es.upm.miw.apaw_practice.domain.models.swimming;

import java.util.ArrayList;
import java.util.List;

public class Apprentice {

    private String foreName;
    private Integer age;
    private String address;
    private List<Inscription> inscriptions;

    public Apprentice() {
        inscriptions = new ArrayList<>();
    }

    public Apprentice(String foreName, Integer age, String address, List<Inscription> inscriptions) {
        this.foreName = foreName;
        this.age = age;
        this.address = address;
        this.inscriptions = inscriptions;
    }

    public String getForeName() {
        return foreName;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public void addInscription(Inscription inscription) {
        this.inscriptions.add(inscription);
    }

    @Override
    public String toString() {
        return "Apprentice{" +
                "foreName='" + foreName + '\'' +
                ", age=" + age + '\'' +
                ", address='" + address + '\'' +
                ", inscriptions='" + inscriptions +
                '}';
    }
}
