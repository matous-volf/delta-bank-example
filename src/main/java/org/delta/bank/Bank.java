package org.delta.bank;

import org.delta.bank.account.*;
import org.delta.bank.interest.InterestApplicator;
import org.delta.bank.print.LogService;
import org.delta.bank.user.Owner;
import org.delta.bank.user.OwnerFactory;
import org.delta.bank.user.OwnerService;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final LogService logService = new LogService();
    private final InterestApplicator interestApplicator = new InterestApplicator();
    private final AccountService accountService = new AccountService();
    private final OwnerService ownerService = new OwnerService();

    public void run() {
        Owner john = ownerService.addOwner("John", "Doe");

        accountService.addBaseAccount(john, 10000);
        accountService.addSavingAccount(john, 10000);
        accountService.addStudentAccount(john, 10000);

        logService.log("Before:");
        for (BaseBankAccount account : accountService.getAccounts().values()) {
            logService.logAccountInfo(account);
        }

        for (BaseBankAccount account : accountService.getAccounts().values()) {
            if (!(account instanceof InterestAccount)) {
                continue;
            }

            interestApplicator.applyInterest(account);
        }

        logService.log("After:");
        for (BaseBankAccount account : accountService.getAccounts().values()) {
            logService.logAccountInfo(account);
        }
    }
}
