package org.delta.bank;

import org.delta.bank.account.*;
import org.delta.bank.interest.InterestApplicator;
import org.delta.bank.print.LogService;
import org.delta.bank.user.Owner;
import org.delta.bank.user.OwnerFactory;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final LogService logService = new LogService();
    private final InterestApplicator interestApplicator = new InterestApplicator();
    private final OwnerFactory ownerFactory = new OwnerFactory();
    private final BankAccountFactory accountFactory = new BankAccountFactory();

    public void run() {
        Owner owner1 = ownerFactory.createOwner("John", "Doe");

        List<BaseBankAccount> accounts = new ArrayList<>();

        accounts.add(accountFactory.createBaseAccount(owner1, 10000));
        accounts.add(accountFactory.createSavingAccount(owner1, 10000));
        accounts.add(accountFactory.createStudentAccount(owner1, 10000));

        logService.log("Before:");
        for (BaseBankAccount account : accounts) {
            logService.logAccountInfo(account);
        }

        for (BaseBankAccount account : accounts) {
            if (!(account instanceof InterestAccount)) {
                continue;
            }

            interestApplicator.applyInterest(account);
        }

        logService.log("After:");
        for (BaseBankAccount account : accounts) {
            logService.logAccountInfo(account);
        }
    }
}
