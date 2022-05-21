package com.capgmn.harvest.dto;

public class TransactionDTO {
  private String customerID;
  private long initialCredit;

  public String getCustomerID() {
    return customerID;
  }

  public void setCustomerID(String customerID) {
    this.customerID = customerID;
  }

  public long getInitialCredit() {
    return initialCredit;
  }

  public void setInitialCredit(long initialCredit) {
    this.initialCredit = initialCredit;
  }

  public TransactionDTO(String customerID, long initialCredit) {
    this.customerID = customerID;
    this.initialCredit = initialCredit;
  }
}
