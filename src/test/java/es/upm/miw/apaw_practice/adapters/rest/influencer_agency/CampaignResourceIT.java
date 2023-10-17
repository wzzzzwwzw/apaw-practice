package es.upm.miw.apaw_practice.adapters.rest.influencer_agency;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Campaign;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Content;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.ArrayList;
import java.util.Date;

@RestTestConfig
class CampaignResourceIT {
    @Autowired
    private WebTestClient webTestClient;


    @Test
    void testCreateCampaign() {
        Campaign campaign = new Campaign(new Date(), new Date());
        campaign.setDescription("New Campaign");
        ArrayList<Content> contents = new ArrayList<>();
        Content content = new Content("Content 1", "Content 1 description");
        contents.add(content);
        campaign.setContents(contents);
        this.webTestClient
                .post()
                .uri(CampaignResource.CAMPAIGNS)
                .body(BodyInserters.fromValue(campaign))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Campaign.class)
                .value(Assertions::assertNotNull);
    }
}