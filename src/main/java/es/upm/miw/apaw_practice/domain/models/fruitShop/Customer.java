package es.upm.miw.apaw_practice.domain.models.fruitShop;

import es.upm.miw.apaw_practice.domain.models.fruitShop.builders.CustomerBuilders;

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

    public static class Builder implements CustomerBuilders.IdCustomer, CustomerBuilders.Optionals {
        private final Customer customer;

        public Builder(){
            customer = new Customer();
        }
        @Override
        public CustomerBuilders.Optionals idCustomer(Integer idCustomer){
            this.customer.idCustomer = idCustomer;
            return this;
        }

        @Override
        public CustomerBuilders.Optionals phone(String phone){
            this.customer.phone = phone;
            return this;
        }

        @Override
        public CustomerBuilders.Optionals email(String email){
            this.customer.email = email;
            return this;
        }

        @Override
        public Customer build(){
            return customer;
        }
    }
}
