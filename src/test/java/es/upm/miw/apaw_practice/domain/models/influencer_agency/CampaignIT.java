package es.upm.miw.apaw_practice.domain.models.influencer_agency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampaignIT {

    @Test
    void testCampaignComposite() {
        CampaignComposite campaignComposite = new CampaignComposite("CampaignComposite");
        assertTrue(campaignComposite.isComposite());
        Campaign campaign = new Campaign();
        campaignComposite.add(campaign);
        assertEquals(1, campaignComposite.getTreeCampaignsList().size());
        campaignComposite.remove(campaign);
        assertEquals(0, campaignComposite.getTreeCampaignsList().size());
    }

    @Test
    void testCampaignLeaf() {
        Campaign campaign = new Campaign();
        assertEquals("Campaign{startDate=null, endDate=null, description='null', contents=null}", campaign.toString());
        assertFalse(campaign.isComposite());
    }
}
