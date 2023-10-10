package es.upm.miw.apaw_practice.domain.models.basketball;

public class Player {
    private String name;
    private String position;
    private Integer age;

    public Player(String name, String position, Integer age) {
        this.name = name;
        this.position = position;
        this.age = age;
    }

    public Player() {

    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", position=" + position +
                '}';
    }
}

