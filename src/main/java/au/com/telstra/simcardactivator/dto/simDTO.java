package au.com.telstra.simcardactivator.dto;

public class simDTO {

    private String iccid;
    private String customerEmail;
    private boolean active;

    // Default constructor
    public simDTO() {
    }

    // Parameterized constructor
    public simDTO(String iccid, String customerEmail) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
    }
    public simDTO(String iccid, String customerEmail, boolean active) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.active=active;
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
    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}