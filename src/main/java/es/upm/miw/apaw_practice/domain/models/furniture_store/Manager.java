package es.upm.miw.apaw_practice.domain.models.furniture_store;

public class Manager {
    private String affiliationNumber;
    private String name;
    private Boolean promotionCandidate;

    public Manager() {
        //empty from framework
    }

    public Manager(String affiliationNumber, String name, Boolean promotionCandidate) {
        this.affiliationNumber = affiliationNumber;
        this.name = name;
        this.promotionCandidate = promotionCandidate;
    }

    public String getAffiliationNumber() {
        return affiliationNumber;
    }

    public void setAffiliationNumber(String affiliationNumber) {
        this.affiliationNumber = affiliationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPromotionCandidate() {
        return promotionCandidate;
    }

    public void setPromotionCandidate(Boolean promotionCandidate) {
        this.promotionCandidate = promotionCandidate;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "affiliationNumber='" + affiliationNumber + '\'' +
                ", name='" + name + '\'' +
                ", promotionCandidate=" + promotionCandidate +
                '}';
    }

}
