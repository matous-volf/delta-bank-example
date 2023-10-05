package org.delta.bank.moneyTransfer;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.InterestAccount;

public class InterestCalculator {
    private InterestConfigurationLoader interestConfigurationLoader = new InterestConfigurationLoader();

    public double calculateInterest(BaseBankAccount account) throws IllegalArgumentException {
        if (!(account instanceof InterestAccount)) {
            throw new IllegalArgumentException("Account must implement InterestAccount interface");
        }

        InterestConfigurator configurator = interestConfigurationLoader.loadConfig((InterestAccount) account);

        return account.getBalance() * configurator.getInterestPercent() / 100;
    }
}
