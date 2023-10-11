package es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.UUID;

public class ApprenticeEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String foreName;
    private Integer age;
    private String address;
    @DBRef
    private InscriptionEntity inscriptionEntity;

    public ApprenticeEntity() {
        // empty for framework
    }

    public ApprenticeEntity(String foreName, Integer age, String address, InscriptionEntity inscriptionEntity) {
        this.id = UUID.randomUUID().toString();
        this.foreName = foreName;
        this.age = age;
        this.address = address;
        this.inscriptionEntity = inscriptionEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getForeName() {
        return foreName;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public InscriptionEntity getInscriptionEntity() {
        return inscriptionEntity;
    }

    public void setInscriptionEntity(InscriptionEntity inscriptionEntity) {
        this.inscriptionEntity = inscriptionEntity;
    }

    @Override
    public int hashCode() {
        return this.foreName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (foreName.equals(((ApprenticeEntity) obj).foreName));
    }

    @Override
    public String toString() {
        return "ApprenticeEntity{" +
                "id='" + id + '\'' +
                ", foreName='" + foreName + '\'' +
                ", age='" + age + '\'' +
                ", address=" + address + '\'' +
                ", inscriptionEntity=" + inscriptionEntity +
                '}';
    }

}
