package org.delta.bank;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SavingBankAccount;
import org.delta.bank.moneyTransfer.MoneyTransferService;
import org.delta.bank.user.Owner;

public class Bank {
    public void run() throws Exception {
        Owner owner1 = new Owner("John", "Doe");

        BaseBankAccount account1 = new SavingBankAccount(owner1, "1234567890", 2000);
        BaseBankAccount account2 = new BaseBankAccount(owner1, "0987654321", 2000);

        System.out.println("Before transfer:");
        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());

        MoneyTransferService moneyTransferService = new MoneyTransferService();

        moneyTransferService.transferMoney(account1, account2, 1000);

        System.out.println("After transfer:");
        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());
    }
}
