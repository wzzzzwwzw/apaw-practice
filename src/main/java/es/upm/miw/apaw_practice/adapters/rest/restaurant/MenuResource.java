package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.domain.services.restaurant.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MenuResource.MENUS)
public class MenuResource {

    static final String MENUS = "/restaurant/menus";
    static final String ID_ID = "/{id}";

    private final MenuService menuService;

    @Autowired
    public MenuResource(MenuService menuService) {
        this.menuService = menuService;
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.menuService.delete(id);
    }
}
