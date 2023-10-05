package org.delta.bank.print;

import org.delta.bank.account.BaseBankAccount;

public interface Logger {
    void log(String message);

    void logAccountInfo(BaseBankAccount account);
}
