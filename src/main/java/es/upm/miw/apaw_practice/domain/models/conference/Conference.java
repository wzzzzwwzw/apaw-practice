package es.upm.miw.apaw_practice.domain.models.conference;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Conference {
    LocalDateTime conferenceDate;
    Boolean hasWorkshops;
    String fieldOfStudy;
    ConferenceLocation location;
    List<Paper> papers;

    public Conference() {
        this.papers = new ArrayList<>();
    }

    public Conference(LocalDateTime conferenceDate, Boolean hasWorkshops, String fieldOfStudy, ConferenceLocation location) {
        this();
        this.conferenceDate = conferenceDate;
        this.hasWorkshops = hasWorkshops;
        this.fieldOfStudy = fieldOfStudy;
        this.location = location;
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

    public ConferenceLocation getLocation() {
        return location;
    }

    public void setLocation(ConferenceLocation location) {
        this.location = location;
    }

    public List<Paper> getPapers() {
        return papers;
    }

    public void addPaper(Paper paper) {
        this.papers.add(paper);
    }

    @Override
    public String toString() {
        return "Conference{" +
                "conferenceDate=" + conferenceDate +
                ", hasWorkshops=" + hasWorkshops +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", location=" + location +
                ", papers=" + papers +
                '}';
    }
}
