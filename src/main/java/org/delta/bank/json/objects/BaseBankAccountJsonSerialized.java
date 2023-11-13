package org.delta.bank.json.objects;

public class BaseBankAccountJsonSerialized {
    private String accountNumber;
    private double balance;
    private int ownerId;

    public BaseBankAccountJsonSerialized(String accountNumber, double balance, int ownerId) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ownerId = ownerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getOwnerId() {
        return ownerId;
    }
}
