package es.upm.miw.apaw_practice.domain.models.swimming;

public class Apprentice {

    private String foreName;
    private Integer age;
    private String address;
    private Inscription inscription;

    public Apprentice() {
        //empty for framework
    }

    public Apprentice(String foreName, Integer age, String address, Inscription inscription) {
        this.foreName = foreName;
        this.age = age;
        this.address = address;
        this.inscription = inscription;
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

    public Inscription getInscription(){
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    @Override
    public String toString() {
        return "Apprentice{" +
                "foreName='" + foreName + '\'' +
                ", age=" + age + '\'' +
                ", address='" + address + '\'' +
                ", inscription='" + inscription +
                '}';
    }
}
