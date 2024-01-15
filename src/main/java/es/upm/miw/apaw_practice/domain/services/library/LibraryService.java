package es.upm.miw.apaw_practice.domain.services.library;

import es.upm.miw.apaw_practice.domain.models.library.Library;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.LibraryPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.LoanPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LibraryService {
    private final LibraryPersistence libraryPersistence;
    private final LoanPersistence loanPersistence;
    @Autowired
    public LibraryService(LibraryPersistence libraryPersistence, LoanPersistence loanPersistence) {
        this.libraryPersistence = libraryPersistence;
        this.loanPersistence = loanPersistence;
    }

    public Library read(String name){
        return this.libraryPersistence.read(name);
    }

    public List<String> findAddressOfLibraryByLoanStatus(Boolean loanStatus){
        return this.libraryPersistence.findAddressByBook(this.loanPersistence.findAddressOfLibraryByLoanStatus(loanStatus));
    }
}
