package es.upm.miw.apaw_practice.domain.models.influencer_agency;

import java.math.BigDecimal;
import java.util.List;

public class Brand {
    private String trademark;
    BigDecimal advertisingBudget;
    String industry;
    Agency agency;
    List<Campaign> campaign;

    public Brand() {
        //empty for framework
    }

    public Brand(String trademark, Agency agency, List<Campaign> campaign) {
        this.trademark = trademark;
        this.agency = agency;
        this.campaign = campaign;
    }

    public String getBrand() {
        return trademark;
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

    @Override
    public String toString() {
        return "Brand{" +
                "brand='" + trademark + '\'' +
                ", advertisingBudget=" + advertisingBudget +
                ", industry='" + industry + '\'' +
                '}';
    }
}
