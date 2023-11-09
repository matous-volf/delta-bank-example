package org.delta.bank;

import com.google.inject.Inject;
import org.delta.bank.account.*;
import org.delta.bank.interest.InterestApplicator;
import org.delta.bank.json.JsonGenerator;
import org.delta.bank.print.Logger;
import org.delta.bank.user.Owner;
import org.delta.bank.user.OwnerFactory;
import org.delta.bank.user.OwnerService;

public class Bank {
    @Inject
    private Logger logger;
    @Inject
    private JsonGenerator jsonGenerator;
    @Inject
    private InterestApplicator interestApplicator;
    @Inject
    private AccountService accountService;
    @Inject
    private OwnerFactory ownerFactory;
    @Inject
    private OwnerService ownerService;

    public void run() {
        Owner john = ownerService.addOwner("John", "Doe");

        accountService.addBaseAccount(john, 10000);
        accountService.addSavingAccount(john, 10000);
        accountService.addStudentAccount(john, 10000);

        logger.log("Before:");
        for (BaseBankAccount account : accountService.getAccounts().values()) {
            logger.logAccountInfo(account);
        }

        for (BaseBankAccount account : accountService.getAccounts().values()) {
            if (!(account instanceof InterestAccount)) {
                continue;
            }

            interestApplicator.applyInterest(account);
        }

        logger.log("After:");
        for (BaseBankAccount account : accountService.getAccounts().values()) {
            logger.logAccountInfo(account);
        }

        logger.log(jsonGenerator.generateJsonString(john));
    }
}
