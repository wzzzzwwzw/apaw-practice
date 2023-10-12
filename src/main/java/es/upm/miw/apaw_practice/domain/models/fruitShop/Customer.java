package es.upm.miw.apaw_practice.domain.models.fruitShop;

public class Customer {

    private Integer id;

    private String phone;

    private String email;

    public Customer() {
        //empty for framework
    }


    public Customer(Integer id, String phone, String email) {
        this.id = id;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
