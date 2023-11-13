package org.delta.bank.moneyTransfer;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.accountValidation.AccountValidationService;
import org.delta.bank.fee.FeeCalculationService;

@Singleton
public class MoneyTransferService {
    @Inject
    private AccountValidationService accountValidationService;
    @Inject
    private FeeCalculationService feeCalculationService ;

    public void transferMoney(BaseBankAccount sourceAccount, BaseBankAccount destinationAccount, double amount) throws Exception {
        double amountWithFee = amount + feeCalculationService.calculateFee(sourceAccount, amount);

        accountValidationService.validateBalance(sourceAccount, amountWithFee);

        sourceAccount.setBalance(sourceAccount.getBalance() - amountWithFee);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
    }

    public void withdrawMoneyFromATM(BaseBankAccount sourceAccount, double amount) throws Exception {
        double amountWithFee = amount + feeCalculationService.calculateFee(sourceAccount, amount);

        accountValidationService.validateBalance(sourceAccount, amountWithFee);

        sourceAccount.setBalance(sourceAccount.getBalance() - amountWithFee);
    }
}
