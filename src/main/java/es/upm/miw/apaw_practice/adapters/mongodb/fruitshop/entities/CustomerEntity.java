package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities;

import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.CustomerEntity;
import es.upm.miw.apaw_practice.domain.models.fruitShop.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Document
public class CustomerEntity {
    @Id
    private String id;

    @Indexed(unique = true)
    private Integer idCustomer;

    private String phone;

    private String email;

    public CustomerEntity() {
        //empty for framework
    }

    public CustomerEntity(Customer customer) {
        BeanUtils.copyProperties(customer, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Customer toCustomer() {
        Customer customer = new Customer();
        BeanUtils.copyProperties(this, customer);
        return customer;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        CustomerEntity objAux = (CustomerEntity) obj;
        return this == obj || obj != null && getClass() == obj.getClass() && (this.idCustomer.equals(objAux.getIdCustomer()));
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id='" + id + '\'' +
                ", idCustomer=" + idCustomer +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
