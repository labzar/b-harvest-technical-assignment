package com.capgmn.harvest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private double amount;
  @ManyToOne
  @JoinColumn(name="account_id")
  @JsonIgnore
  private Account account;

  public Transaction() {
  }
  public Transaction(double amount, Account account) {
    this.amount = amount;
    this.account = account;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  @Override
  public String toString() {
    return "Transaction{" +
            "id=" + id +
            ", amount=" + amount +
            ", account=" + account +
            '}';
  }
}
