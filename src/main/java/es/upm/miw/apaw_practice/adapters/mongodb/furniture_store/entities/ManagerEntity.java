package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities;

import es.upm.miw.apaw_practice.domain.models.furniture_store.Manager;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class ManagerEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String affiliationNumber;
    private String name;
    private Boolean promotionCandidate;

    public ManagerEntity() {
        //empty from framework
    }

    public ManagerEntity(Manager manager) {
        BeanUtils.copyProperties(manager, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getAffiliationNumber() {
        return affiliationNumber;
    }

    public void setAffiliationNumber(String affiliationNumber) {
        this.affiliationNumber = affiliationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPromotionCandidate() {
        return promotionCandidate;
    }

    public void setPromotionCandidate(Boolean promotionCandidate) {
        this.promotionCandidate = promotionCandidate;
    }

    @Override
    public int hashCode() {
        return this.affiliationNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass()
                && (affiliationNumber.equals(((ManagerEntity) obj).affiliationNumber));
    }

    @Override
    public String toString() {
        return "Manager{" +
                "affiliationNumber='" + affiliationNumber + '\'' +
                ", name='" + name + '\'' +
                ", promotionCandidate=" + promotionCandidate +
                '}';
    }

}
