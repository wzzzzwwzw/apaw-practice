package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.domain.models.school.Classroom;
import es.upm.miw.apaw_practice.domain.services.school.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ClassroomResource.CLASSROOMS)
public class ClassroomResource {
    static final String CLASSROOMS = "/school/classrooms";

    static final String LOCATION_ID = "/{location}";

    private final ClassroomService classroomService;

    @Autowired
    public ClassroomResource(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @PostMapping
    public Classroom create(@RequestBody Classroom classroom) {
        return this.classroomService.create(classroom);
    }

    @GetMapping(LOCATION_ID)
    public Classroom read(@PathVariable String location) {
        return this.classroomService.read(location);
    }

    @PatchMapping
    public void updateLockers(@RequestBody List<Classroom> classrooms) {
        this.classroomService.updateLockers(classrooms.stream());
    }
}