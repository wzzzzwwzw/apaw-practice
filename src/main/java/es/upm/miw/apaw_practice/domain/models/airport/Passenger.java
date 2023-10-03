package es.upm.miw.apaw_practice.domain.models.airport;
import java.time.LocalDate;
public class Passenger {

   private String name;
   private Integer age;
   private String numberOfPhone;

   public Passenger(){
       //empty for framework
   }
    public Passenger(String name, Integer age, String numberOfPhone) {
        this.name = name;
        this.age = age;
        this.numberOfPhone = numberOfPhone;
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

    public String getNumberOfPhone() {
        return numberOfPhone;
    }

    public void setNumberOfPhone(String numberOfPhone) {
        this.numberOfPhone = numberOfPhone;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", numberOfPhone='" + numberOfPhone + '\'' +
                '}';
    }
}
