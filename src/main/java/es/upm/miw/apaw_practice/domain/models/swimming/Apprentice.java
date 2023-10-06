package es.upm.miw.apaw_practice.domain.models.swimming;

public class Apprentice {

    private String fullName;
    private Integer age;
    private String address;

    public Apprentice() {
        //empty for framework
    }

    public Apprentice(String fullName, Integer age, String address) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void getAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Apprentice{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
