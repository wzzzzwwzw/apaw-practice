package es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class InscriptionEntity {

    private String inscriptionNumber;
    private LocalDateTime recordDate;
    private Boolean asset;

    public InscriptionEntity() {
        // empty for framework
    }

    public InscriptionEntity(LocalDateTime recordDate, Boolean asset) {
        this.inscriptionNumber = UUID.randomUUID().toString();
        this.recordDate = recordDate;
        this.asset = asset;
    }

    public String getInscriptionNumber() {
        return inscriptionNumber;
    }

    public void setInscriptionNumber(String inscriptionNumber) {
        this.inscriptionNumber = inscriptionNumber;
    }

    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDateTime recordDate) {
        this.recordDate = recordDate;
    }

    public Boolean getAsset() {
        return asset;
    }

    public void setAsset(Boolean asset) {
        this.asset = asset;
    }

    @Override
    public String toString() {
        return "InscriptionEntity{" +
                ", inscriptionNumber='" + inscriptionNumber + '\'' +
                ", recordDate='" + recordDate + '\'' +
                ", asset=" + asset +
                '}';
    }
}
