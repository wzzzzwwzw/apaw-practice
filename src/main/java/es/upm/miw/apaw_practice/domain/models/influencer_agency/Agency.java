package es.upm.miw.apaw_practice.domain.models.influencer_agency;

import es.upm.miw.apaw_practice.domain.models.influencer_agency.builders.AgencyBuilder;

public class Agency {

    private String company;
    private String address;

    private Integer phone;

    public Agency() {
        //empty for framework
    }

    public Agency(String agency, String address) {
        this.company = agency;
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }

    public static class Builder implements AgencyBuilder.Company, AgencyBuilder.Address, AgencyBuilder.Phone, AgencyBuilder.Build {

        private final Agency agency;

        public Builder() {
            this.agency = new Agency();
        }

        @Override
        public AgencyBuilder.Address company(String company) {
            this.agency.company = company;
            return this;
        }

        @Override
        public AgencyBuilder.Phone address(String address) {
            this.agency.address = address;
            return this;
        }

        @Override
        public AgencyBuilder.Build phone(Integer phone) {
            this.agency.phone = phone;
            return this;
        }

        @Override
        public Agency build() {
            return this.agency;
        }
    }
}
