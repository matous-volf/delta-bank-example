package org.delta.bank.interest;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.InterestAccount;

@Singleton
public class InterestCalculator {
    @Inject
    private InterestConfigurationLoader interestConfigurationLoader;

    public double calculateInterest(BaseBankAccount account) throws IllegalArgumentException {
        if (!(account instanceof InterestAccount)) {
            throw new IllegalArgumentException("Account must implement InterestAccount interface");
        }

        InterestConfigurator configurator = interestConfigurationLoader.loadConfig((InterestAccount) account);

        return account.getBalance() * configurator.getInterestPercent() / 100;
    }
}
