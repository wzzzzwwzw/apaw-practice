package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities;

import es.upm.miw.apaw_practice.domain.models.influencer_agency.Brand;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Campaign;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BrandEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String trademark;
    private BigDecimal advertisingBudget;
    private String industry;
    @DBRef
    private AgencyEntity agency;
    @DBRef
    private List<CampaignEntity> campaigns;

    public BrandEntity() {
        //empty for framework
    }

    public BrandEntity(String trademark, AgencyEntity agency, List<CampaignEntity> campaigns) {
        this.trademark = trademark;
        this.agency = agency;
        this.campaigns = campaigns;
        this.id = UUID.randomUUID().toString();
    }

    public void setBrand(String brand) {
        this.trademark = brand;
    }

    public BigDecimal getAdvertisingBudget() {
        return advertisingBudget;
    }

    public void setAdvertisingBudget(BigDecimal advertisingBudget) {
        this.advertisingBudget = advertisingBudget;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public AgencyEntity getAgency() {
        return agency;
    }

    public void setAgency(AgencyEntity agency) {
        this.agency = agency;
    }

    public List<CampaignEntity> getCampaigns() {
        return campaigns;
    }

    public void setCampaign(List<CampaignEntity> campaigns) {
        this.campaigns = campaigns;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "trademark='" + trademark + '\'' +
                ", advertisingBudget=" + advertisingBudget +
                ", industry='" + industry + '\'' +
                ", agency=" + agency +
                ", campaigns=" + campaigns +
                '}';
    }

    public Brand toBrand() {
        List<Campaign> listOfCampaigns = new ArrayList<>();
        for (CampaignEntity c : this.campaigns) {
            listOfCampaigns.add(c.toCampaign());
        }
        return new Brand(this.trademark, this.agency.toAgency(), listOfCampaigns);
    }
}
