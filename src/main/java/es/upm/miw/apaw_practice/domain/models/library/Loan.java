package es.upm.miw.apaw_practice.domain.models.library;

import java.time.LocalDateTime;

public class Loan {
    private Book book;
    private LocalDateTime loanDateTime;
    private LocalDateTime returnDateTime;
    private Boolean loanStatus;

    public Loan(Book book, LocalDateTime loanDateTime, LocalDateTime returnDateTime, Boolean loanStatus) {
        this.book = book;
        this.loanDateTime = loanDateTime;
        this.returnDateTime = returnDateTime;
        this.loanStatus = loanStatus;
    }

    public Book getBook() { return book; }

    public void setBook(Book book) { this.book=book; }

    public LocalDateTime getLoanDateTime() { return loanDateTime;}

    public void setLoanDateTime(LocalDateTime loanDateTime) { this.loanDateTime = loanDateTime;}

    public LocalDateTime getReturnDateTime() { return returnDateTime;}

    public void setReturnDateTime(LocalDateTime returnDateTime) { this.returnDateTime = returnDateTime;}

    public Boolean getLoanStatus() { return loanStatus;}

    public void setLoanStatus(Boolean loanStatus) { this.loanStatus = loanStatus;}

    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book +
                ", loanDateTime=" + loanDateTime +
                ", returnDateTime=" + returnDateTime +
                ", loanStatus=" + loanStatus +
                '}';
    }
}
