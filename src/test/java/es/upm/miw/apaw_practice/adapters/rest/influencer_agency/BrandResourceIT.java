package es.upm.miw.apaw_practice.adapters.rest.influencer_agency;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Campaign;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
class BrandResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getCampaignsByBrand() {
        this.webTestClient
                .get()
                .uri(BrandResource.BRANDS + BrandResource.TRADEMARK + BrandResource.CAMPAIGNS, "Brand1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Campaign.class)
                .value(Assertions::assertNotNull);
    }


    @Test
    void testGetCampaignsByBrandException() {
        this.webTestClient
                .get()
                .uri(BrandResource.BRANDS + BrandResource.TRADEMARK + BrandResource.CAMPAIGNS, "Brandx")
                .exchange()
                .expectStatus().isNotFound();
    }

}
