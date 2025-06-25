package com.skypay.reservation;

public class User {
  private final int id;
  private int balance;

  public User(int id, int balance) {
    this.id = id;
    this.balance = balance;
  }

  public int getId() {
    return id;
  }

  public int getBalance() {
    return balance;
  }

  public void deductBalance(int amount) {
    this.balance -= amount;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", balance=" + balance +
        '}';
  }
}
