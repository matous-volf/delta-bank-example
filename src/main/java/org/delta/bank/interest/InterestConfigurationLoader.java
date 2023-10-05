package org.delta.bank.interest;

import org.delta.bank.account.InterestAccount;
import org.delta.bank.account.SavingBankAccount;
import org.delta.bank.account.StudentBankAccount;

public class InterestConfigurationLoader {
    private static final double SAVING_INTEREST_PERCENT = 8;
    private static final double STUDENT_INTEREST_PERCENT = 1;

    public InterestConfigurator loadConfig(InterestAccount sourceAccount) {
        if (sourceAccount instanceof StudentBankAccount) {
            return new InterestConfigurator(STUDENT_INTEREST_PERCENT);
        } else if (sourceAccount instanceof SavingBankAccount) {
            return new InterestConfigurator(SAVING_INTEREST_PERCENT);
        } else {
            throw new IllegalArgumentException("Account must implement InterestAccount interface");
        }
    }
}
