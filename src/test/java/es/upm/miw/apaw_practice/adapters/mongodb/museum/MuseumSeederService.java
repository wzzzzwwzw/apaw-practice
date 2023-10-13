package es.upm.miw.apaw_practice.adapters.mongodb.museum;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.ArtWorkRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.ExhibitionRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.PainterRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.RoomRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtWorkEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ExhibitionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PainterEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.RoomEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class MuseumSeederService {

    @Autowired
    private ArtWorkRepository artWorkRepository;
    @Autowired
    private ExhibitionRepository exhibitionRepository;
    @Autowired
    private PainterRepository painterRepository;
    @Autowired
    private RoomRepository roomRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("----------- Museum Initial Load -----------");

        RoomEntity[] rooms = {
                new RoomEntity("Sala 012", 1, 9.75),
                new RoomEntity("Sala 056", 0, 8.5),
                new RoomEntity("Sala 038", 1, 9.0),
                new RoomEntity("Sala 015", 1, 7.5),
                new RoomEntity("Sala 029", 1, 7.25),
                new RoomEntity("Sala 009", 1, 7.25),
                new RoomEntity("ALMACÉN", -1, 0.0),
        };
        roomRepository.saveAll(Arrays.asList(rooms));

        ArtWorkEntity[] artWorks = {
                new ArtWorkEntity("P001174", "Las Meninas", 1656, true, rooms[0]),
                new ArtWorkEntity("P002823", "Tríptico del Jardín de las delicias", 1495, true, rooms[1]),
                new ArtWorkEntity("P000741", "La maja vestida", 1803, true, rooms[2]),
                new ArtWorkEntity("P000742", "La maja desnuda", 1797, true, rooms[2]),
                new ArtWorkEntity("P001173", "Las hilanderas", 1658, true, rooms[3]),
                new ArtWorkEntity("P001670", "Las tres Gracias", 1633, true, rooms[3]),
                new ArtWorkEntity("P000796", "El albañil herido", 1787, false, rooms[6]),
                new ArtWorkEntity("P000015", "La Anunciación", 1787, true, rooms[1]),
                new ArtWorkEntity("P001172", "La rendición de Breda", 1635, true, rooms[5]),
        };
        artWorkRepository.saveAll(Arrays.asList(artWorks));

        PainterEntity[] painters = {
                new PainterEntity("Francisco de", "Goya y Lucientes", LocalDate.of(1746, 3, 30), LocalDate.of(1828, 4, 16), List.of(artWorks[2], artWorks[3], artWorks[6])),
                new PainterEntity("Diego Rodríguez de Silva y", "Velázquez", LocalDate.of(1599, 6, 6), LocalDate.of(1660, 8, 6), List.of(artWorks[0], artWorks[4], artWorks[8])),
                new PainterEntity("Jheronimus van Aken, el", "Bosco", LocalDate.of(1450, 1, 1), LocalDate.of(1516, 1, 1), List.of(artWorks[1])),
                new PainterEntity("Pedro Pablo", "Rubens", LocalDate.of(1577, 6, 28), LocalDate.of(1640, 5, 30), List.of(artWorks[5])),
                new PainterEntity("Fra", "Angelico", LocalDate.of(1395, 1, 1), LocalDate.of(1455, 2, 18), List.of(artWorks[7])),
        };
        painterRepository.saveAll(Arrays.asList(painters));

        ExhibitionEntity[] exhibitions = {
                new ExhibitionEntity("Pasiones mitológicas: Tiziano, Veronese, Allori, Rubens, Ribera, Poussin, Van Dyck, Velázquez", "Museo Nacional del Prado (Madrid, España)", LocalDate.of(2021, 3, 2), LocalDate.of(2021, 7, 4), List.of(artWorks[4], artWorks[5])),
                new ExhibitionEntity("Goya: Luces y Sombras", "CaixaForum (Barcelona, España)", LocalDate.of(2012, 3, 16), LocalDate.of(2012, 6, 24), List.of(artWorks[2], artWorks[6])),
                new ExhibitionEntity("Reencuentro", "Museo Nacional del Prado (Madrid, España)", LocalDate.of(2020, 6, 6), LocalDate.of(2021, 7, 25), List.of(artWorks[7], artWorks[8])),
        };
        exhibitionRepository.saveAll(Arrays.asList(exhibitions));
    }

    public void deleteAll() {
        this.exhibitionRepository.deleteAll();
        this.painterRepository.deleteAll();
        this.artWorkRepository.deleteAll();
        this.roomRepository.deleteAll();
    }
}
