package org.delta.bank.accountValidation;

import org.delta.bank.account.BaseBankAccount;

public class AccountValidationService {
    public void validateBalance(BaseBankAccount sourceAccount, double amount) throws Exception {
        if (sourceAccount.getBalance() < amount) {
            throw new Exception();
        }
    }
}
