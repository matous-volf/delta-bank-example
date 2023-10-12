package org.delta.bank.print;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.user.Owner;

public class ConsoleLogger implements Logger {
    public void log(String message) {
        System.out.println(message);
    }

    public void logAccountInfo(BaseBankAccount account) {
        String accountInfo = String.format("%s %s owned by %s contains %.2f",
                account.getClass().getSimpleName(),
                account.getAccountNumber(),
                account.getOwner().getLastName(),
                account.getBalance());

        System.out.println(accountInfo);
    }

    public void logAccountCreation(BaseBankAccount account) {
        String accountInfo = String.format("Created a %s %s owned by %s",
                account.getClass().getSimpleName(),
                account.getAccountNumber(),
                account.getOwner().getLastName());

        System.out.println(accountInfo);
    }

    public void logOwnerCreation(Owner owner) {
        String ownerInfo = String.format("Created an owner: %s %s",
                owner.getFirstName(),
                owner.getLastName());

        System.out.println(ownerInfo);
    }
}
