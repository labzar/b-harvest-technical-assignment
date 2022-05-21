package com.capgmn.harvest.entities;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "account")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String surname;
  private double balance;
  private String customerId;
  private String accountNumber;

  @OneToMany(fetch = FetchType.EAGER,
          mappedBy="account",
          cascade = CascadeType.ALL)
  private List<Transaction> transactions;

  public Account() {}

  public Account(String name, String surname, double balance, String customerID, String accountNumber) {
    this.name = name;
    this.surname = surname;
    this.balance = balance;
    this.customerId = customerID;
    this.accountNumber = accountNumber;
  }

  public Account( String name, String surname, double balance, String customerID, String accountNumber, List<Transaction> transactions) {
    this.name = name;
    this.surname = surname;
    this.balance = balance;
    this.customerId = customerID;
    this.accountNumber = accountNumber;
    this.transactions = transactions;
  }

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
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

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
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

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }
}