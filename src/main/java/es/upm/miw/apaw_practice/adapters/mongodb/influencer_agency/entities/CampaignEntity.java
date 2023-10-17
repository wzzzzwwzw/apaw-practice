package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities;

import es.upm.miw.apaw_practice.domain.models.influencer_agency.Campaign;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CampaignEntity {
    @Id
    private String id;
    private Date startDate;
    private Date endDate;
    private String description;
    private List<ContentEntity> contents;


    public CampaignEntity() {
        //empty for framework
    }

    public CampaignEntity(Campaign campaign) {
        BeanUtils.copyProperties(campaign, this);
        this.id = UUID.randomUUID().toString();
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

    public List<ContentEntity> getContents() {
        return contents;
    }

    public void setContents(List<ContentEntity> contents) {
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

    public Campaign toCampaign() {
        Campaign campaign = new Campaign();
        campaign.setContents(new ArrayList<>());
        BeanUtils.copyProperties(this, campaign);
        return campaign;
    }
}