package es.upm.miw.apaw_practice.adapters.mongodb.bakery;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.upm.miw.apaw_practice.adapters.mongodb.bakery.daos.ProductRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bakery.daos.ProductTypeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bakery.daos.ShelfRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bakery.daos.TicketRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities.ProductEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities.ProductTypeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities.ShelfEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities.TicketEntity;
import es.upm.miw.apaw_practice.domain.models.bakery.ProductType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class BakerySeederService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ShelfRepository shelfRepository;
    @Autowired
    private TicketRepository ticketRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("----------- Bakery Initial Load -----------");

        ProductTypeEntity[] productTypes = {
                new ProductTypeEntity(new ProductType("Panes Clasicos", "Nuestra variedad de panes clasicos", "PANCL")),
                new ProductTypeEntity(new ProductType("Salados", "Nuestra variedad de salados", "SALS")),
                new ProductTypeEntity(new ProductType("Dulces", "Nuestra variedad de dulces", "DULS"))
        };
        this.productTypeRepository.saveAll(Arrays.asList(productTypes));

        ProductEntity[] products = {
                new ProductEntity("Pan integral", "Nuestro pan integral", new BigDecimal("1.20"), true, LocalDate.of(2023, 1, 1), productTypes[0]),
                new ProductEntity("Pan rustico", "Nuestro pan rustico clasico", new BigDecimal("0.80"), false, LocalDate.of(2023, 2, 1), productTypes[0]),
                new ProductEntity("Napolitana de chocolate", "La napolitana mas dulce", new BigDecimal("0.5"), false, LocalDate.of(2023, 3, 1), productTypes[2]),
                new ProductEntity("Empanadilla clasica", "Empanadilla de pisto tradicional", new BigDecimal("0.4"), true, LocalDate.of(2023, 4, 1), productTypes[1]),
                new ProductEntity("Ensaimada", "Ensaimada sin relleno", new BigDecimal("0.3"), true, LocalDate.of(2023, 5, 1), productTypes[2]),
                new ProductEntity("Rosquilletas", "Rosquilletas clasicas", new BigDecimal("1.10"), false, LocalDate.of(2023, 6, 1), productTypes[1]),
                new ProductEntity("Rosquilletas de chocolate", "Rosquilletas con pepitas de chocolate", new BigDecimal("1.60"), false, LocalDate.of(2023, 7, 1), productTypes[2])

        };
        this.productRepository.saveAll(Arrays.asList(products));

        ShelfEntity[] shelves = {
                new ShelfEntity("Estanteria 1", 20, 2, "Pasillo 1", List.of(products[0], products[1])),
                new ShelfEntity("Estanteria 2", 30, 3, "Pasillo 2", List.of(products[2], products[4], products[6])),
                new ShelfEntity("Estanteria 3", 40, 4, "Pasillo 3", List.of(products[3], products[5]))

        };
        this.shelfRepository.saveAll(Arrays.asList(shelves));

        TicketEntity[] tickets = {
                new TicketEntity(LocalDateTime.of(2023, 1, 1, 10, 50, 51), new BigDecimal("2.00"), 2, List.of(products[0], products[1])),
                new TicketEntity(LocalDateTime.of(2023, 2, 20, 20, 54, 30), new BigDecimal("0.50"), 1, List.of(products[2])),
                new TicketEntity(LocalDateTime.of(2023, 3, 15, 15, 58, 34), new BigDecimal("0.70"), 2, List.of(products[3], products[4])),
                new TicketEntity(LocalDateTime.of(2023, 4, 10, 9, 12, 55), new BigDecimal("2.70"), 2, List.of(products[5], products[6])),
                new TicketEntity(LocalDateTime.of(2024, 4, 10, 9, 12, 59), new BigDecimal("100.0"), 1, null)
        };
        this.ticketRepository.saveAll(Arrays.asList(tickets));
    }

    public void deleteAll() {
        this.productRepository.deleteAll();
        this.productTypeRepository.deleteAll();
        this.shelfRepository.deleteAll();
        this.ticketRepository.deleteAll();
    }
}
