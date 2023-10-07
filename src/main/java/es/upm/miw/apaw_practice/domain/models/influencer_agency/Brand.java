package es.upm.miw.apaw_practice.domain.models.influencer_agency;

import java.math.BigDecimal;
import java.util.List;

public class Brand {
    private String trademark;
    private BigDecimal advertisingBudget;
    private String industry;
    private Agency agency;
    private List<Campaign> campaigns;

    public Brand() {
        //empty for framework
    }

    public Brand(String trademark, Agency agency, List<Campaign> campaigns) {
        this.trademark = trademark;
        this.agency = agency;
        this.campaigns = campaigns;
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

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaign(List<Campaign> campaigns) {
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
}
