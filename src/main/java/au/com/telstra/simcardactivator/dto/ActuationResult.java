package au.com.telstra.simcardactivator.dto;

public class ActuationResult{
  private boolean success;
  
  public ActuationResult() {}
  
  public ActuationResult(boolean success) {
    this.success = success;
  }
  
  public boolean getSuccess() {
    return this.success;
  }
  
  public void setSuccess(boolean success) {
    this.success = success;
  }
  
  public String toString() {
    return "ActuationResult {success=" + this.success + "}";
  }
}