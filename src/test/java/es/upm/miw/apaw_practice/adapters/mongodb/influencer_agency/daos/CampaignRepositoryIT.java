package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities.CampaignEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities.ContentEntity;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Content;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class CampaignRepositoryIT {

    @Autowired
    private CampaignRepository campaignRepository;

    @Test
    void testFindByDescription() {
        CampaignEntity campaignToSave = new CampaignEntity();
        campaignToSave.setDescription("Description");
        Date startDate = new Date();
        Date endDate = new Date();
        campaignToSave.setStartDate(startDate);
        campaignToSave.setEndDate(endDate);
        List<ContentEntity> contents = List.of(
                new ContentEntity(new Content(".", ".")),
                new ContentEntity(new Content(".", "."))
        );
        campaignToSave.setContents(contents);
        campaignRepository.save(campaignToSave);

        Optional<CampaignEntity> foundCampaign =
                campaignRepository.findByDescription("Description");

        assertTrue(foundCampaign.isPresent());
        assertEquals("Description", foundCampaign.get().getDescription());
        assertEquals(startDate, foundCampaign.get().getStartDate());
        assertEquals(endDate, foundCampaign.get().getEndDate());
        assertEquals(contents.size(), foundCampaign.get().getContents().size());
    }
}