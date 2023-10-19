package org.delta.bank.print;

import com.google.inject.Inject;
import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.user.Owner;

public class LogService {
    @Inject
    private Logger logger;

    public void log(String message) {
        logger.log(message);
    }

    public void logAccountInfo(BaseBankAccount account) {
        logger.logAccountInfo(account);
    }

    public void logAccountCreation(BaseBankAccount account) {
        logger.logAccountCreation(account);
    }
    public void logOwnerCreation(Owner owner) {
        logger.logOwnerCreation(owner);
    }
}
