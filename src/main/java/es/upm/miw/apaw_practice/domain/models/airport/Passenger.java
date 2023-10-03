package es.upm.miw.apaw_practice.domain.models.airport;
import java.time.LocalDate;
public class Passenger {

   private String name;
   private int age;
   private String numberOfPhone;

   public Passenger(){
       //empty for framework
   }
    public Passenger(String name, int age, String numberOfPhone) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
