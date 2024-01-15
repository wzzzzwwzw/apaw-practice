package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.school.Subject;
import es.upm.miw.apaw_practice.domain.services.school.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(SubjectResource.SUBJECTS)
public class SubjectResource {
    static final String SUBJECTS = "/school/subjects";

    static final String TITLE_ID = "/{title}";
    static final String SEARCH_DESCRIPTION_BY_SMARTBOARD = "/search-desc-smartboard";

    private final SubjectService subjectService;

    @Autowired
    public SubjectResource(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(TITLE_ID)
    public Subject read(@PathVariable String title) {
        return this.subjectService.read(title);
    }

    @PostMapping
    public Subject create(@RequestBody Subject subject) {
        return this.subjectService.create(subject);
    }

    @DeleteMapping(TITLE_ID)
    public void delete(@PathVariable String title) {
        this.subjectService.delete(title);
    }

    @GetMapping(SEARCH_DESCRIPTION_BY_SMARTBOARD)
    public List<String> searchUniqueDescriptionBySmartBoard(@RequestParam String q) {
        Boolean smartBoard = new LexicalAnalyzer().extractWithAssure(q, "smartboard", Boolean::parseBoolean);
        return this.subjectService.searchUniqueDescriptionBySmartBoard(smartBoard);
    }
}