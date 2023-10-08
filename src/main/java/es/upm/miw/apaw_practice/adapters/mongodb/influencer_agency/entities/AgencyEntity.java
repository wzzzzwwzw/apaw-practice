package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities;

import es.upm.miw.apaw_practice.domain.models.influencer_agency.Agency;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.UUID;

public class AgencyEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String company;
    private String address;

    private Integer phone;

    public AgencyEntity() {
        //empty for framework
    }

    public AgencyEntity(Agency agency) {
        BeanUtils.copyProperties(agency, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }
}
