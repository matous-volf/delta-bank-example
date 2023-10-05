package org.delta.bank.fee;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SavingBankAccount;
import org.delta.bank.account.StudentBankAccount;

public class FeeConfigurationLoader {
    private static final double BASE_PERCENT_FEE_THRESHOLD = 1000;
    private static final double BASE_PERCENT_FEE = 10;
    private static final double BASE_FIXED_FEE = 5;
    private static final double SAVING_PERCENT_FEE_THRESHOLD = 500;
    private static final double SAVING_PERCENT_FEE = 15;
    private static final double SAVING_FIXED_FEE = 50;

    public FeeConfigurator loadConfig(BaseBankAccount sourceAccount) {
        if (sourceAccount instanceof StudentBankAccount)
            return new FeeConfigurator(0, 0, 0, true);
        else if (sourceAccount instanceof SavingBankAccount)
            return new FeeConfigurator(SAVING_FIXED_FEE, SAVING_PERCENT_FEE, SAVING_PERCENT_FEE_THRESHOLD, false);
        else
            return new FeeConfigurator(BASE_FIXED_FEE, BASE_PERCENT_FEE, BASE_PERCENT_FEE_THRESHOLD, false);
    }
}
