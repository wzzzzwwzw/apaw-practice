package es.upm.miw.apaw_practice.domain.models.influencer_agency;

import es.upm.miw.apaw_practice.domain.models.influencer_agency.composite.TreeCampaigns;

import java.util.ArrayList;
import java.util.List;

public class CampaignComposite implements TreeCampaigns {
    private final String description;
    private final List<TreeCampaigns> treeCampaignsList;

    public CampaignComposite(String description) {
        this.description = description;
        this.treeCampaignsList = new ArrayList<>();
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeCampaigns treeCampaigns) {
        this.treeCampaignsList.add(treeCampaigns);
    }

    @Override
    public void remove(TreeCampaigns treeCampaigns) {
        this.treeCampaignsList.remove(treeCampaigns);
    }

    public List<TreeCampaigns> getTreeCampaignsList() {
        return treeCampaignsList;
    }

    @Override
    public String toString() {
        return "CampaignComposite{" +
                "description='" + description + '\'' +
                ", treeCampaignsList=" + treeCampaignsList +
                '}';
    }
}
