package org.delta.bank.account;

import org.delta.bank.user.Owner;

public class BaseBankAccount {
    private Owner owner;
    private String accountNumber;
    private double balance;

    public BaseBankAccount(Owner owner, String accountNumber, double balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
