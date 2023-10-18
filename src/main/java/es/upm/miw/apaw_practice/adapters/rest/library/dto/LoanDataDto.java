package es.upm.miw.apaw_practice.adapters.rest.library.dto;

import java.time.LocalDateTime;

public class LoanDataDto {
    private LocalDateTime loanDateTime;
    private LocalDateTime returnDateTime;
    private Boolean loanStatus;

    public LoanDataDto(){
        //empty for framework
    }
    public LoanDataDto(LocalDateTime loanDateTime, LocalDateTime returnDateTime, Boolean loanStatus) {
        this.loanDateTime = loanDateTime;
        this.returnDateTime = returnDateTime;
        this.loanStatus = loanStatus;
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
}
