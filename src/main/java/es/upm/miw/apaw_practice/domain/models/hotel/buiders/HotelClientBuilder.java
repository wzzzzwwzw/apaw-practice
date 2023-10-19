package es.upm.miw.apaw_practice.domain.models.hotel.buiders;

import es.upm.miw.apaw_practice.domain.models.hotel.HotelClient;

public interface HotelClientBuilder {
    interface DNI {
        HotelClientBuilder.Email dni(String dni);
    }

    interface Email {
        HotelClientBuilder.Telephone email(String email);
    }

    interface Telephone {
        HotelClientBuilder.Partnership telephone(Integer telephone);
    }

    interface Partnership {
        HotelClientBuilder.Build partnership(Boolean partnership);
    }

    interface Build {
        HotelClient build();
    }
}
