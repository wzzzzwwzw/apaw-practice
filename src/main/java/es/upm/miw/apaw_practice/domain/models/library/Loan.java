package es.upm.miw.apaw_practice.domain.models.library;

import java.time.LocalDateTime;

public class Loan {
    private Book book;
    private LocalDateTime localDateTime;
    private LocalDateTime returnDateTime;
    private Boolean loanStatus;

    public Loan(Book book, LocalDateTime localDateTime, LocalDateTime returnDateTime, Boolean loanStatus) {
        this.book = book;
        this.localDateTime = localDateTime;
        this.returnDateTime = returnDateTime;
        this.loanStatus = loanStatus;
    }

    public Book getBook() { return book; }

    public void setBook(Book book) { this.book=book; }

    public LocalDateTime getLocalDateTime() { return localDateTime;}

    public void setLocalDateTime(LocalDateTime localDateTime) { this.localDateTime = localDateTime;}

    public LocalDateTime getReturnDateTime() { return returnDateTime;}

    public void setReturnDateTime(LocalDateTime returnDateTime) { this.returnDateTime = returnDateTime;}

    public Boolean getLoanStatus() { return loanStatus;}

    public void setLoanStatus(Boolean loanStatus) { this.loanStatus = loanStatus;}

    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book +
                ", localDateTime=" + localDateTime +
                ", returnDateTime=" + returnDateTime +
                ", loanStatus=" + loanStatus +
                '}';
    }
}
