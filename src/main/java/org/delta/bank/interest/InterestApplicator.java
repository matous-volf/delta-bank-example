package org.delta.bank.interest;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.account.BaseBankAccount;

@Singleton
public class InterestApplicator {
    @Inject
    private InterestCalculator interestCalculator;

    public void applyInterest(BaseBankAccount account) {
        double interest = interestCalculator.calculateInterest(account);
        account.setBalance(account.getBalance() + interest);
    }
}
