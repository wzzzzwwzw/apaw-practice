package es.upm.miw.apaw_practice.adapters.rest.fruitshop;

import es.upm.miw.apaw_practice.domain.services.fruitshop.FruitShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FruitShopResource.FRUITSHOP)
public class FruitShopResource {

    static final String FRUITSHOP = "/fruitShop/fruitShops";
    static final String ID_NAME = "/{name}";

    private final FruitShopService fruitShopService;

    @Autowired
    public FruitShopResource(FruitShopService fruitShopService){
        this.fruitShopService = fruitShopService;
    }

    @DeleteMapping(ID_NAME)
    public void delete(@PathVariable String name){
        this.fruitShopService.delete(name);
    }
}
