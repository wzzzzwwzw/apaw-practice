package es.upm.miw.apaw_practice.domain.models.influencer_agency.composite;

public interface TreeCampaigns {
    Boolean isComposite();

    void add(TreeCampaigns treeCampaigns);

    void remove(TreeCampaigns treeCampaigns);
}
