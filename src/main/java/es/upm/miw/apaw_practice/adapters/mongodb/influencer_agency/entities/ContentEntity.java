package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities;

import es.upm.miw.apaw_practice.domain.models.influencer_agency.Content;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public class ContentEntity {
    @Id
    private String id;
    private String information;
    private Boolean viral;
    private String creator;
    private String platform;

    public ContentEntity() {
        //empty for framework
    }

    public ContentEntity(Content content) {
        BeanUtils.copyProperties(content, this);
        this.id = UUID.randomUUID().toString();
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

    public Content toContent() {
        Content content = new Content();
        BeanUtils.copyProperties(this, content);
        return content;
    }
}
