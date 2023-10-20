package es.upm.miw.apaw_practice.adapters.mongodb.library.entities;

import es.upm.miw.apaw_practice.domain.models.library.Loan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class LoanEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String loanCode;
    private BookEntity bookEntity;
    private LocalDateTime loanDateTime;
    private LocalDateTime returnDateTime;
    private Boolean loanStatus;

    public LoanEntity() {
        //empty for framework
    }

    public LoanEntity(String loanCode, BookEntity bookEntity, LocalDateTime loanDateTime, LocalDateTime returnDateTime, Boolean loanStatus) {
        this.id = UUID.randomUUID().toString();
        this.loanCode = loanCode;
        this.bookEntity = bookEntity;
        this.loanDateTime = loanDateTime;
        this.returnDateTime = returnDateTime;
        this.loanStatus = loanStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(String loanCode) {
        this.loanCode = loanCode;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    public LocalDateTime getLoanDateTime() {
        return loanDateTime;
    }

    public void setLoanDateTime(LocalDateTime loanDateTime) {
        this.loanDateTime = loanDateTime;
    }

    public LocalDateTime getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(LocalDateTime returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    public Boolean getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(Boolean loanStatus) {
        this.loanStatus = loanStatus;
    }

    public Loan toLoan() {
        return new Loan(this.loanCode, bookEntity.toBook(), this.loanDateTime, this.returnDateTime, this.loanStatus);
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((LoanEntity) obj).id));
    }

    @Override
    public int hashCode() {
        return this.loanCode.hashCode();
    }

    @Override
    public String toString() {
        return "LoanEntity{" +
                "id='" + id + '\'' +
                ", loanCode='" + loanCode + '\'' +
                ", bookEntity=" + bookEntity +
                ", loanDateTime=" + loanDateTime +
                ", returnDateTime=" + returnDateTime +
                ", loanStatus=" + loanStatus +
                '}';
    }
}
