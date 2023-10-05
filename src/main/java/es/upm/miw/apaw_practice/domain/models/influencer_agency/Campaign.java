package es.upm.miw.apaw_practice.domain.models.influencer_agency;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Campaign {
    Date startDate;
    Date endDate;
    String description;
    List<Content> content;


    public Campaign(){
        //empty for framework
    }

    public Campaign(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        content = new ArrayList<>();
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

    @Override
    public String toString() {
        return "Campaign{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                '}';
    }
}
