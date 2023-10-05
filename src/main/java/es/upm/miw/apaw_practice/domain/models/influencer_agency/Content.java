package es.upm.miw.apaw_practice.domain.models.influencer_agency;

public class Content {
    String information;
    Boolean viral;
    String creator;
    String platform;

    public Content() {
        //empty for framework
    }

    public Content(String information, String creator) {
        this.information = information;
        this.creator = creator;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Boolean getViral() {
        return viral;
    }

    public void setViral(Boolean viral) {
        this.viral = viral;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Content{" +
                "information='" + information + '\'' +
                ", viral=" + viral +
                ", creator='" + creator + '\'' +
                ", platform='" + platform + '\'' +
                '}';
    }
}
