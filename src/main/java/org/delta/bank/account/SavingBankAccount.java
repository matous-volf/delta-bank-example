package org.delta.bank.account;

import org.delta.bank.user.Owner;

public class SavingBankAccount extends BaseBankAccount implements InterestAccount {
    public SavingBankAccount(Owner owner, String accountNumber, double balance) {
        super(owner, accountNumber, balance);
    }
}
