package com.capgmn.harvest.dto;

import com.capgmn.harvest.entities.Transaction;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

public class AccountInfoDTO {
  private String name;
  private String surname;
  private String customerId;
  private List<Transaction> transactions;

  public AccountInfoDTO(String name, String surname, String customerId, List<Transaction> transactions) {
    this.name = name;
    this.surname = surname;
    this.customerId = customerId;
    this.transactions = transactions;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }
}
