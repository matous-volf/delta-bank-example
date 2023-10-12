package org.delta.bank.print;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.user.Owner;

public interface Logger {
    void log(String message);

    void logAccountInfo(BaseBankAccount account);

    void logAccountCreation(BaseBankAccount account);

    void logOwnerCreation(Owner owner);
}
