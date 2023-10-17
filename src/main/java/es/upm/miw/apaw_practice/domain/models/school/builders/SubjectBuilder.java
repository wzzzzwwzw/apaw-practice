package es.upm.miw.apaw_practice.domain.models.school.builders;

import es.upm.miw.apaw_practice.domain.models.school.Subject;

public interface SubjectBuilder {

    interface Title {
        SubjectBuilder.Description title(String title);
    }

    interface Description {
         SubjectBuilder.Bilingual description(String description);
    }

    interface Bilingual {
        SubjectBuilder.Credits bilingual(Boolean bilingual);
    }

    interface Credits {
        SubjectBuilder.Build credits(Integer credits);
    }

    interface Build {
        Subject build();
    }
}
