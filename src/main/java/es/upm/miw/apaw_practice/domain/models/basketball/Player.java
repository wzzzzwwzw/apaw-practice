package es.upm.miw.apaw_practice.domain.models.basketball;

public class Player {
    private String email;
    private String position;
    private Integer age;

    public Player(String email, String position, Integer age) {
        this.email = email;
        this.position = position;
        this.age = age;
    }

    public Player() {

    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public Integer getAge() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
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
                "email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", position=" + position +
                '}';
    }
}

