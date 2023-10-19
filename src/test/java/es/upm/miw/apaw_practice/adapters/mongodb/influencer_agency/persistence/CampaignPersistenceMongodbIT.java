package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Campaign;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class CampaignPersistenceMongodbIT {

    @Autowired
    private CampaignPersistenceMongodb campaignPersistence;

    @Test
    void testCreateCampaign() {
        Campaign campaign = new Campaign(new Date(), new Date());
        Campaign created = this.campaignPersistence.create(campaign);
        assertNotNull(created);
    }

    @Test
    void testFindByDescription() {
        Campaign campaign = this.campaignPersistence.findByDescription("Description1");
        assertNotNull(campaign);
        assertEquals("Description1", campaign.getDescription());
    }

    @Test
    void testFindByDescriptionFailure() {
        assertThrows(NotFoundException.class, () -> this.campaignPersistence.findByDescription("NonExistentDescription"));
    }

    @Test
    void testSave() {
        Campaign campaign = new Campaign(new Date(), new Date());
        this.campaignPersistence.save(campaign);
        Campaign saved = this.campaignPersistence.findByDescription(campaign.getDescription());
        assertNotNull(saved);
    }

    @Test
    void testFindCreatorsByAgencyPhone() {
        var creators = this.campaignPersistence.findCreatorsByAgencyPhone(222).toList();
        assertFalse(creators.isEmpty());
        assertTrue(creators.contains("Creator5"));
    }

    @Test
    void testFindCreatorsByAgencyPhoneFailure() {
        assertThrows(NotFoundException.class, () -> this.campaignPersistence.findCreatorsByAgencyPhone(999999999));
    }
}
