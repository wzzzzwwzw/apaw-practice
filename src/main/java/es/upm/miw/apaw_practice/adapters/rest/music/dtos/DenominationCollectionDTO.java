package es.upm.miw.apaw_practice.adapters.rest.music.dtos;

import java.util.List;

public class DenominationCollectionDTO {

    private List<String> denominations;

    public DenominationCollectionDTO() {
        // empty for framework
    }

    public DenominationCollectionDTO(List<String> denominations) {
        this.denominations = denominations;
    }

    public List<String> getDenominations() {
        return denominations;
    }

    public void setDenominations(List<String> denominations) {
        this.denominations = denominations;
    }
}
