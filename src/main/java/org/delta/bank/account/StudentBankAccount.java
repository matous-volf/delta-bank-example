package org.delta.bank.account;

import org.delta.bank.user.Owner;

public class StudentBankAccount extends BaseBankAccount implements InterestAccount {
    public StudentBankAccount(Owner owner, String accountNumber, double balance) {
        super(owner, accountNumber, balance);
    }
}
