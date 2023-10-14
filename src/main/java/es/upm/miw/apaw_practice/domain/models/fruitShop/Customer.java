package es.upm.miw.apaw_practice.domain.models.fruitShop;

public class Customer {

    private Integer idCustomer;

    private String phone;

    private String email;

    public Customer() {
        //empty for framework
    }


    public Customer(Integer idCustomer, String phone, String email) {
        this.idCustomer = idCustomer;
        this.phone = phone;
        this.email = email;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
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
                "idCustomer=" + idCustomer +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
