package es.upm.miw.apaw_practice.domain.models.swimming;

import java.time.LocalDateTime;

public class Inscription {
    private Integer inscriptionNumber;
    private LocalDateTime registrationDate;
    private Boolean asset;

    public Inscription() {
        //empty for framework
    }

    public Inscription(Integer inscriptionNumber, LocalDateTime registrationDate, Boolean asset) {
        this.inscriptionNumber = inscriptionNumber;
        this.registrationDate = registrationDate;
        this.asset = asset;
    }

    public Integer getInscriptionNumber() {
        return inscriptionNumber;
    }

    public void setInscriptionNumber(Integer inscriptionNumber) {
        this.inscriptionNumber = inscriptionNumber;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
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
                ", registrationDate=" + registrationDate + '\'' +
                ", asset=" + asset +
                '}';
    }
}
