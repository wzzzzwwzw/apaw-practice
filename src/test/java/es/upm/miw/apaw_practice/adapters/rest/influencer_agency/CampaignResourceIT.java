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
import java.util.List;

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


    @Test
    void testUpdateContentForCampaign() {
        Content content = new Content("Content 2", "Content 2 creator");
        this.webTestClient
                .put()
                .uri(CampaignResource.CAMPAIGNS + CampaignResource.DESCRIPTION_ID +
                        CampaignResource.CONTENTS, "Description2")
                .body(BodyInserters.fromValue(content))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdateContentForCampaignException() {
        Content content = new Content("Content", "Content creator");
        this.webTestClient
                .put()
                .uri(CampaignResource.CAMPAIGNS + CampaignResource.CONTENTS, "Description5")
                .body(BodyInserters.fromValue(content))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testFindCreatorsByAgencyPhone() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(CampaignResource.CAMPAIGNS + CampaignResource.SEARCH)
                        .queryParam("phone", 111111111)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class)
                .value(Assertions::assertNotNull)
                .value(creators -> Assertions.assertEquals(6, creators.size()))
                .value(creators -> Assertions.assertEquals("Creator1", creators.get(0)))
                .value(creators -> Assertions.assertEquals("Creator2", creators.get(1)))
                .value(creators -> Assertions.assertEquals("Creator3", creators.get(2)));
    }

    @Test
    void testFindCreatorsByAgencyPhoneException() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(CampaignResource.CAMPAIGNS + CampaignResource.SEARCH)
                        .queryParam("phone", 1)
                        .build())
                .exchange()
                .expectStatus().isNotFound();
    }
}