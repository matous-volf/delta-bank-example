package org.delta.bank.moneyTransfer;

public class InterestConfigurator {
    private double interestPercent;

    public InterestConfigurator(double interestPercent) {
        this.interestPercent = interestPercent;
    }

    public double getInterestPercent() {
        return interestPercent;
    }
}
