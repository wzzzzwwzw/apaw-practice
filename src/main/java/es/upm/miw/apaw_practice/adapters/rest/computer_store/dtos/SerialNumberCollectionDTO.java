package es.upm.miw.apaw_practice.adapters.rest.computer_store.dtos;

import java.util.List;


public class SerialNumberCollectionDTO {
    private List<String> serialNumbers;

    public SerialNumberCollectionDTO() {
        // empty for framework
    }

    public SerialNumberCollectionDTO(List<String> serialNumbers) {
        this.serialNumbers = serialNumbers;
    }

    public List<String> getSerialNumbers() {
        return serialNumbers;
    }

    public void setSerialNumbers(List<String> serialNumbers) {
        this.serialNumbers = serialNumbers;
    }
}
