package au.com.telstra.simcardactivator.entities;

import javax.persistence.*;

@Entity
public class simEntity {
    @Id
    private String iccid;
    private String customerEmail;

    // Default constructor
    public simEntity() {
    }

    // Parameterized constructor
    public simEntity(String iccid, String customerEmail) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
    }

    // Getters and Setters
    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}