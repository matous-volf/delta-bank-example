package org.delta.bank.moneyTransfer;

public class FeeConfigurator {
    private boolean isFreeOfFee;
    private double fixedFee;
    private double basePercent;
    private double basePercentThreshold;

    public FeeConfigurator(double fixedFee, double basePercent, double basePercentThreshold, boolean isFreeOfFee) {
        this.fixedFee = fixedFee;
        this.basePercent = basePercent;
        this.basePercentThreshold = basePercentThreshold;
        this.isFreeOfFee = isFreeOfFee;
    }

    public double getFixedFee() {
        return fixedFee;
    }

    public double getBasePercent() {
        return basePercent;
    }

    public double getBasePercentThreshold() {
        return basePercentThreshold;
    }

    public boolean isFreeOfFee() {
        return isFreeOfFee;
    }
}
