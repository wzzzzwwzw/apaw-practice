package es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class ApprenticeEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String foreName;
    private Integer age;
    private String address;
    private List<InscriptionEntity> inscriptionEntities;

    public ApprenticeEntity() {
        // empty for framework
    }

    public ApprenticeEntity(String foreName, Integer age, String address, List<InscriptionEntity> inscriptionEntities) {
        this.id = UUID.randomUUID().toString();
        this.foreName = foreName;
        this.age = age;
        this.address = address;
        this.inscriptionEntities = inscriptionEntities;
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

    public List<InscriptionEntity> getInscriptionEntities() {
        return inscriptionEntities;
    }

    public void setInscriptionEntities(List<InscriptionEntity> inscriptionEntities) {
        this.inscriptionEntities = inscriptionEntities;
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
                ", inscriptionEntities=" + inscriptionEntities +
                '}';
    }

}
