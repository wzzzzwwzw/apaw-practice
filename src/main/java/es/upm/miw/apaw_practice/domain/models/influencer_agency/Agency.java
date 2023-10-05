package es.upm.miw.apaw_practice.domain.models.influencer_agency;

public class Agency {

    String company;
    String address;

    Integer phone;

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
                "agency='" + company + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }
}
