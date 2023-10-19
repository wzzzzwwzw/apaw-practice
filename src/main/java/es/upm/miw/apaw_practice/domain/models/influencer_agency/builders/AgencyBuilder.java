package es.upm.miw.apaw_practice.domain.models.influencer_agency.builders;

import es.upm.miw.apaw_practice.domain.models.influencer_agency.Agency;

public interface AgencyBuilder {
    interface Company {
        AgencyBuilder.Address company(String company);
    }

    interface Address {
        AgencyBuilder.Phone address(String address);
    }

    interface Phone {
        AgencyBuilder.Build phone(Integer phone);
    }

    interface Build {
        Agency build();
    }
}
