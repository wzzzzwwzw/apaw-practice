package es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class InscriptionEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String inscriptionNumber;
    private LocalDateTime registrationDate;
    private Boolean asset;

    public InscriptionEntity() {
        // empty for framework
    }

    public InscriptionEntity(String inscriptionNumber, LocalDateTime registrationDate, Boolean asset) {
        this.id = UUID.randomUUID().toString();
        this.inscriptionNumber = inscriptionNumber;
        this.registrationDate = registrationDate;
        this.asset = asset;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInscriptionNumber() {
        return inscriptionNumber;
    }

    public void setInscriptionNumber(String inscriptionNumber) {
        this.inscriptionNumber = inscriptionNumber;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Boolean getAsset() {
        return asset;
    }

    public void setAsset(Boolean asset) {
        this.asset = asset;
    }

    @Override
    public int hashCode() {
        return this.inscriptionNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null
                && getClass() == obj.getClass()
                && (inscriptionNumber.equals(((InscriptionEntity) obj).inscriptionNumber));
    }

    @Override
    public String toString() {
        return "InscriptionEntity{" +
                "id='" + id + '\'' +
                ", inscriptionNumber='" + inscriptionNumber + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", asset=" + asset +
                '}';
    }
}
