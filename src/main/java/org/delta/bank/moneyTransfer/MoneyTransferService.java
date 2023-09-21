package org.delta.bank.moneyTransfer;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.accountValidation.AccountValidationService;

public class MoneyTransferService {
    private final AccountValidationService accountValidationService = new AccountValidationService();
    private final FeeCalculationService feeCalculationService = new FeeCalculationService();

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
