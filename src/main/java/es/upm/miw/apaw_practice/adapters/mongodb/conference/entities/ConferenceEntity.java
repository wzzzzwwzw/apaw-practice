package es.upm.miw.apaw_practice.adapters.mongodb.conference.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class ConferenceEntity {
    @Id
    private String id;
    private LocalDateTime conferenceDate;
    private Boolean hasWorkshops;
    private String fieldOfStudy;
    @DBRef
    private ConferenceLocationEntity locationEntity;
    @DBRef
    private List<PaperEntity> papersEntities;

    public ConferenceEntity() {
        // empty for framework
    }

    public ConferenceEntity(LocalDateTime conferenceDate, Boolean hasWorkshops, String fieldOfStudy, ConferenceLocationEntity locationEntity, List<PaperEntity> papersEntities) {
        this.id = UUID.randomUUID().toString();
        this.conferenceDate = conferenceDate;
        this.hasWorkshops = hasWorkshops;
        this.fieldOfStudy = fieldOfStudy;
        this.locationEntity = locationEntity;
        this.papersEntities = papersEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getConferenceDate() {
        return conferenceDate;
    }

    public void setConferenceDate(LocalDateTime conferenceDate) {
        this.conferenceDate = conferenceDate;
    }

    public Boolean getHasWorkshops() {
        return hasWorkshops;
    }

    public void setHasWorkshops(Boolean hasWorkshops) {
        this.hasWorkshops = hasWorkshops;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public ConferenceLocationEntity getLocationEntity() {
        return locationEntity;
    }

    public void setLocationEntity(ConferenceLocationEntity locationEntity) {
        this.locationEntity = locationEntity;
    }

    public List<PaperEntity> getPapersEntities() {
        return papersEntities;
    }

    public void setPapersEntities(List<PaperEntity> papersEntities) {
        this.papersEntities = papersEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceEntity that = (ConferenceEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ConferenceEntity{" +
                "id='" + id + '\'' +
                ", conferenceDate=" + conferenceDate +
                ", hasWorkshops=" + hasWorkshops +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", locationEntity=" + locationEntity +
                ", papersEntities=" + papersEntities +
                '}';
    }
}
