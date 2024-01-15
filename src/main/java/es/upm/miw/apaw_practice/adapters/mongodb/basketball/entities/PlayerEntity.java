package es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities;

import es.upm.miw.apaw_practice.domain.models.basketball.Player;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class PlayerEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    private String position;
    private Integer age;

    public PlayerEntity() {

    }

    public PlayerEntity(String email, String position, Integer age) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.position = position;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Player toPlayer(){
        return new Player(this.email, this.position, this.age);
    }

    @Override
    public int hashCode() {
        return this.email.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (email.equals(((PlayerEntity) obj).email));
    }

    @Override
    public String toString() {
        return "PlayerEntity{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", position=" + position +
                ", age='" + age + '\'' +
                '}';
    }

}
