package org.delta.bank.moneyTransfer;

import org.delta.bank.account.BaseBankAccount;

public class InterestApplicator {
    private final InterestCalculator interestCalculator;

    public InterestApplicator(InterestCalculator interestCalculator) {
        this.interestCalculator = interestCalculator;
    }

    public void applyInterest(BaseBankAccount account) {
        double interest = interestCalculator.calculateInterest(account);
        account.setBalance(account.getBalance() + interest);
    }
}
