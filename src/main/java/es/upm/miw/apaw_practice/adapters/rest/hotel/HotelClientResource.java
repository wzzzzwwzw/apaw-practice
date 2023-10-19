package es.upm.miw.apaw_practice.adapters.rest.hotel;

import es.upm.miw.apaw_practice.domain.services.hotel.HotelClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(HotelResource.HOTELS + HotelClientResource.CLIENTS)
public class HotelClientResource {
    static final String CLIENTS = "/clients";

    static final String CLIENT_DNI = "/{clientDNI}";

    private final HotelClientService hotelClientService;

    public HotelClientResource(HotelClientService hotelClientService) {
        this.hotelClientService = hotelClientService;
    }

    @DeleteMapping(CLIENT_DNI)
    public void delete(@PathVariable String clientDNI) {
        this.hotelClientService.deleteClient(clientDNI);
    }
}
