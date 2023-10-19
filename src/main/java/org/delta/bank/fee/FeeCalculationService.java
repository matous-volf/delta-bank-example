package org.delta.bank.fee;

import com.google.inject.Inject;
import org.delta.bank.account.BaseBankAccount;

public class FeeCalculationService {
    @Inject
    private FeeConfigurationLoader feeConfigurationLoader;

    public double calculateFee(BaseBankAccount sourceAccount, double amount) {
        FeeConfigurator feeConfigurator = feeConfigurationLoader.loadConfig(sourceAccount);

        if (feeConfigurator.isFreeOfFee())
            return 0;

        double fee = 0;

        if (amount >= feeConfigurator.getBasePercentThreshold()) {
            fee = amount * feeConfigurator.getBasePercent() / 100;
        }
        fee += feeConfigurator.getFixedFee();

        return fee;
    }
}
