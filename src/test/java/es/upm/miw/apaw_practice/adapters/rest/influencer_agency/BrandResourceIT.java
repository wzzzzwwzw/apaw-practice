package es.upm.miw.apaw_practice.adapters.rest.influencer_agency;

import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.InfluencerAgencySeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Campaign;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

@RestTestConfig
class BrandResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private InfluencerAgencySeederService influencerAgencySeederService;

    @BeforeEach
    void resetDB() {
        this.influencerAgencySeederService.deleteAll();
        this.influencerAgencySeederService.seedDatabase();
    }

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

    @Test
    void testUpdateBrand() {
        this.webTestClient
                .patch()
                .uri(BrandResource.BRANDS + "/Brand1")
                .bodyValue(1000)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdateBrandException() {
        this.webTestClient
                .patch()
                .uri(BrandResource.BRANDS + "/nike")
                .bodyValue(1000)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testSumBudgetsByPlatform() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(BrandResource.BRANDS + BrandResource.SEARCH)
                        .queryParam("platform", "Platform1")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(BigDecimal.class)
                .value(Assertions::assertNotNull)
                .value(sum -> Assertions.assertEquals(new BigDecimal("1209.00"), sum));
    }

    @Test
    void testSumBudgetsByPlatformException() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(BrandResource.BRANDS + BrandResource.SEARCH)
                        .queryParam("platform", "Platformx")
                        .build())
                .exchange()
                .expectStatus().isNotFound();
    }

}
