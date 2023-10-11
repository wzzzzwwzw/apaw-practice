package es.upm.miw.apaw_practice.domain.models.swimming;

import java.time.LocalDateTime;

public class Inscription {
    private Integer inscriptionNumber;
    private LocalDateTime recordDate;
    private Boolean asset;

    public Inscription() {
        //empty for framework
    }

    public Inscription(Integer inscriptionNumber, LocalDateTime recordDate, Boolean asset) {
        this.inscriptionNumber = inscriptionNumber;
        this.recordDate = recordDate;
        this.asset = asset;
    }

    public Integer getInscriptionNumber() {
        return inscriptionNumber;
    }

    public void setInscriptionNumber(Integer inscriptionNumber) {
        this.inscriptionNumber = inscriptionNumber;
    }

    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDateTime recordDate) {
        this.recordDate = recordDate;
    }

    public Boolean getAsset() {
        return this.asset;
    }

    public void setAsset(Boolean asset) {
        this.asset = asset;
    }

    @Override
    public String toString() {
        return "Inscription{" +
                "inscriptionNumber=" + inscriptionNumber + '\'' +
                ", recordDate=" + recordDate + '\'' +
                ", asset=" + asset +
                '}';
    }
}
