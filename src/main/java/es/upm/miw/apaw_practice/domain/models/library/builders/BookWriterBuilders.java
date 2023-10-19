package es.upm.miw.apaw_practice.domain.models.library.builders;

import es.upm.miw.apaw_practice.domain.models.library.BookWriter;

public interface BookWriterBuilders {
    interface Nickname {
        Optionals nickname(String nickname);
    }

    interface Optionals {
        Optionals name(String name);

        Optionals numberOfBook(Integer numberOfBook);

        BookWriter build();
    }
}
