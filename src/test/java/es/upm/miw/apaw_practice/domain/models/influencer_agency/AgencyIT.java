package es.upm.miw.apaw_practice.domain.models.influencer_agency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgencyIT {

    @Test
    void testBuilder() {
        Agency agency = new Agency.Builder()
                .company("company")
                .address("address")
                .phone(123456789)
                .build();
        assertEquals("company", agency.getCompany());
        assertEquals("address", agency.getAddress());
        assertEquals(123456789, agency.getPhone());
    }

}
