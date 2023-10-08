package es.upm.miw.apaw_practice.adapters.rest.zoo;


import es.upm.miw.apaw_practice.domain.services.zoo.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ZooResource.ZOO)
public class ZooResource {

    static final String ZOO = "/zoo/zoos";
    static final String NAME_ID = "/{name}";

    private final ZooService zooService;

    @Autowired
    public ZooResource(ZooService zooService) {
        this.zooService = zooService;
    }

    @DeleteMapping(NAME_ID)
    public void delete(@PathVariable String name) {
        this.zooService.delete(name);
    }

}

