package au.com.telstra.simcardactivator.dto;

public class SimCard {
    private String iccid;
    
    public SimCard() {}
    
    public SimCard(String iccid) {
      this.iccid = iccid;
    }
    
    public String getIccid() {
      return this.iccid;
    }
    
    public void setICCID(String iccid) {
      this.iccid = iccid;
    }
    
    public String toString() {
      return "SimCard {iccid=" + this.iccid + "}";
    }
  }