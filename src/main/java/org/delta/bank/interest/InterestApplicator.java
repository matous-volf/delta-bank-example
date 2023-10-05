package org.delta.bank.interest;

import org.delta.bank.account.BaseBankAccount;

public class InterestApplicator {
    private final InterestCalculator interestCalculator = new InterestCalculator();

    public void applyInterest(BaseBankAccount account) {
        double interest = interestCalculator.calculateInterest(account);
        account.setBalance(account.getBalance() + interest);
    }
}
