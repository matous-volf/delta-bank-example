package org.delta.bank.accountValidation;

import com.google.inject.Singleton;
import org.delta.bank.account.BaseBankAccount;

@Singleton
public class AccountValidationService {
    public void validateBalance(BaseBankAccount sourceAccount, double amount) throws Exception {
        if (sourceAccount.getBalance() < amount) {
            throw new Exception();
        }
    }
}
