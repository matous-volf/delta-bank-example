package org.delta.bank;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.InterestAccount;
import org.delta.bank.account.SavingBankAccount;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.moneyTransfer.InterestApplicator;
import org.delta.bank.moneyTransfer.InterestCalculator;
import org.delta.bank.moneyTransfer.MoneyTransferService;
import org.delta.bank.user.Owner;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    public void run() throws Exception {
        Owner owner1 = new Owner("John", "Doe");

        List<BaseBankAccount> accounts = new ArrayList<>();

        accounts.add(new BaseBankAccount(owner1, "0987654321", 10000));
        accounts.add(new SavingBankAccount(owner1, "1234567890", 10000));
        accounts.add(new StudentBankAccount(owner1, "999999999", 10000));

        System.out.println("Before transfer:");
        for (int i = 0; i < accounts.size(); i++) {
            BaseBankAccount account = accounts.get(i);
            System.out.println(i + ". " + account.getOwner().getLastName() + " | " + account.getBalance());
        }

//        MoneyTransferService moneyTransferService = new MoneyTransferService();
//        moneyTransferService.transferMoney(accounts.get(0), accounts.get(1), 2000);
//        moneyTransferService.transferMoney(accounts.get(2), accounts.get(1), 2000);

        InterestCalculator interestCalculator = new InterestCalculator();
        InterestApplicator interestApplicator = new InterestApplicator(interestCalculator);

        for (BaseBankAccount account : accounts) {
            if (!(account instanceof InterestAccount)) {
                continue;
            }

            interestApplicator.applyInterest(account);
        }

        System.out.println("After transfer:");
        for (int i = 0; i < accounts.size(); i++) {
            BaseBankAccount account = accounts.get(i);
            System.out.println(i + ". " + account.getOwner().getLastName() + " | " + account.getBalance());
        }
    }
}
