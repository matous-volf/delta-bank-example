package org.delta.bank.account;

import com.google.inject.Inject;
import org.delta.bank.print.LogService;
import org.delta.bank.user.Owner;

public class BankAccountFactory {
    @Inject
    private LogService logService;
    @Inject
    private AccountNumberService accountNumberService;

    public BaseBankAccount createBaseAccount(Owner owner, double balance) {
        BaseBankAccount account = new BaseBankAccount(owner, accountNumberService.generateAccountNumber(), balance);

        logService.logAccountCreation(account);

        return account;
    }

    public SavingBankAccount createSavingAccount(Owner owner, double balance) {
        SavingBankAccount account = new SavingBankAccount(owner, accountNumberService.generateAccountNumber(), balance);

        logService.logAccountCreation(account);

        return account;
    }

    public StudentBankAccount createStudentAccount(Owner owner, double balance) {
        StudentBankAccount account = new StudentBankAccount(owner, accountNumberService.generateAccountNumber(), balance);

        logService.logAccountCreation(account);

        return account;
    }
}
