package es.upm.miw.apaw_practice.domain.models.influencer_agency;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Campaign {
    private Date startDate;
    private Date endDate;
    private String description;
    private List<Content> contents;


    public Campaign(){
        //empty for framework
    }

    public Campaign(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        contents = new ArrayList<>();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", contents=" + contents +
                '}';
    }
}
